package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.EmployeeDTO;
import com.example.Exception.EmployeeNotFoundException;
import com.example.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping()
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO dto) {
		return ResponseEntity.ok(employeeService.createEmployee(dto));
	}
	
	
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping()
	public List<EmployeeDTO> getAll(){
		return employeeService.getAllEmployee();
	}
	
	@PutMapping("/{id}")
	public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) throws EmployeeNotFoundException {
		return employeeService.updateEmployee(id, dto);
	}
	@DeleteMapping("/{id}")
	public void deleteEmp(@PathVariable Long id) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(id); 
	}
	
	

}
