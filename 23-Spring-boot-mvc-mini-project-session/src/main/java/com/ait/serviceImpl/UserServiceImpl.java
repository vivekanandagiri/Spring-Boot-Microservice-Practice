package com.ait.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import com.ait.dto.UserDTO;
import com.ait.entity.UserEntity;
import com.ait.repository.UserRepository;
import com.ait.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	// constructor injection
	UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO registerUser(UserDTO user) {
		//checking for user email if exist
		UserEntity existingUserEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserEmail != null) {
            return null; 
        }
		//checking for user phone no if exist
		Optional<UserEntity> existingUserPhone = userRepository.findByPhone(user.getPhone());
		if(existingUserPhone.isPresent()) {
			return null;
		}
		
		UserEntity uEntity = new UserEntity();
		BeanUtils.copyProperties(user, uEntity);
		userRepository.save(uEntity);
		return user;
	}
	
    @Override
    public UserDTO findByEmail(String email) {
        UserEntity findByEmail = userRepository.findByEmail(email);
        if (findByEmail != null) {
            UserDTO userDto = new UserDTO();
            BeanUtils.copyProperties(findByEmail, userDto);
            return userDto;
        }
        return null;
    }
	@Override
	public UserDTO loginUser(String email, String password) {
		 UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity !=null) {
			if(password.equals(userEntity.getPassword())) {
				UserDTO dto=new UserDTO();
				BeanUtils.copyProperties(userEntity, dto);
				return dto;
			}
		}
		return null;
	}

}
