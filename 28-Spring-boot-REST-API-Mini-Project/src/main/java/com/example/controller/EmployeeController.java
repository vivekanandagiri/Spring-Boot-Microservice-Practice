package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.EmployeeDTO;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/register",name="register the product")
	public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employee) {
			EmployeeDTO registerEmployee = employeeService.registerEmployee(employee);
			return registerEmployee;
	}
	@GetMapping(value = "/list_employee")
	public List<EmployeeDTO> getListofEmployee(){
		List<EmployeeDTO> allEmployee = employeeService.fetchAllEmployee();
		return allEmployee;
	}
	@GetMapping(value = "/delete/{id}")
	public Map<String, String> deleteEmployee(@PathVariable("id")Long id) {
		HashMap<String, String> map = new HashMap<>();
		employeeService.deleteEmployee(id);
		map.put("msg","employee deleted successfully:"+id);
		return map;
	}
	
	@GetMapping(value = "/edit/{id}")
	public EmployeeDTO editEmployee(@PathVariable("id")Long id) {
		EmployeeDTO employeeById = employeeService.fetchEmployeeById(id);
		return employeeById;
	}
	
	@PostMapping(value = "/update")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO ) {
		EmployeeDTO updateEmployee = employeeService.updateEmployee(employeeDTO);
		return updateEmployee;
	
	}
	
	

}
