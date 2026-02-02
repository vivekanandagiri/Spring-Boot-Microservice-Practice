package com.ait.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.UserEntity;





public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
	Optional<UserEntity>findByPhone(Long phone);

	

}
