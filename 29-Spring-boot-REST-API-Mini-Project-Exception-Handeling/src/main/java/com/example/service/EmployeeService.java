package com.example.service;

import java.util.List;

import com.example.DTO.EmployeeDTO;


public interface EmployeeService {
	
//	public EmployeeDTO loginEmployee(String email, String password);
//
//	EmployeeDTO findByEmail(String email);
//	
	public EmployeeDTO registerEmployee (EmployeeDTO employeeDTO);
	
	public EmployeeDTO updateEmployee(EmployeeDTO product);
	
	public EmployeeDTO fetchEmployeeById(Long id);
	
	public List<EmployeeDTO> fetchAllEmployee(); 
	
	public EmployeeDTO deleteEmployee(Long id);
	

}
