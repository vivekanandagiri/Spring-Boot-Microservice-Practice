package com.ait.dto;

import com.ait.util.Gender;

import lombok.Data;
@Data
public class UserDTO {
	public Long id;
	public String fname;
	public String lname;
	public String email;
	public Long phone;
	public String password;
	public Gender gender;
	
}
