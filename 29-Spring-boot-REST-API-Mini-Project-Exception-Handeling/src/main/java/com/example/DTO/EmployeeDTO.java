package com.example.DTO;

import com.example.util.Gender;

import lombok.Data;


@Data
public class EmployeeDTO {
	public Long id;
	public String password;
	public String name;
	public String email;
	public Long phone;
	public Double salary;
	public String jobTitle;
	public Gender gender;
	public String city;
}
