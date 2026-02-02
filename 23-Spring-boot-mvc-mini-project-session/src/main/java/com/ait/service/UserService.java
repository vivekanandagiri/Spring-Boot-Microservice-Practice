package com.ait.service;

import com.ait.dto.UserDTO;

public interface UserService {
	public UserDTO registerUser(UserDTO user);
	
	public UserDTO loginUser(String username, String password);

	UserDTO findByEmail(String email);
	

}
