package com.example.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.DTO.EmployeeDTO;
import com.example.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/register",name="register the product")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employee) {
			EmployeeDTO registerEmployee = employeeService.registerEmployee(employee);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
										.path("/{id}")
										.buildAndExpand(registerEmployee.getId())
										.toUri();
			return ResponseEntity.created(uri).body(registerEmployee); 
	} 
	
	
	@GetMapping(value = "/list_employee")
	public ResponseEntity<List<EmployeeDTO>> getListofEmployee(){
		List<EmployeeDTO> allEmployee = employeeService.fetchAllEmployee();
		return ResponseEntity.ok(allEmployee);
	} 
	
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Map<String, String>>  deleteEmployee(@PathVariable("id")Long id) {
		employeeService.deleteEmployee(id);
		HashMap<String, String> response = new HashMap<>();
		response.put("message", "Employee with ID " + id + " deleted successfully.");
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/edit/{id}")
	public ResponseEntity<EmployeeDTO> editEmployee(@PathVariable("id")Long id) {
		EmployeeDTO employeeById = employeeService.fetchEmployeeById(id);
		return ResponseEntity.ok(employeeById);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<EmployeeDTO> updateEmployee( @RequestBody EmployeeDTO employeeDTO ) {
		 // Ensure the ID in the path matches the DTO's ID (or set it) ----------@PathVariable ("id")Long id,
//		if(employeeDTO.getId()==null || !employeeDTO.getId().equals(id)) {
//			// This is a common validation, could throw another custom exception or Bad Request
//            // For simplicity, let's assume DTO.id is set correctly or service handles it.
//            // A more robust solution might check DTO.id or throw an exception if mismatch.
//		}
//		// If employee doesn't exist, service's registerOrUpdate (via findById) should throw EmployeeNotFoundException
//		employeeDTO.setId(id);
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeDTO);
		return ResponseEntity.ok(updatedEmployee);
	
	}
	
	

}
