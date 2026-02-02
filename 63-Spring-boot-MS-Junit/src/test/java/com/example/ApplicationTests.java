package com.example;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DTO.EmployeeDTO;
import com.example.Exception.EmployeeNotFoundException;
import com.example.Service.EmployeeService;

@SpringBootTest
class ApplicationTests {
	
	private final EmployeeService employeeService = new EmployeeService();

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateEmployee() {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setName("vivek");
		dto.setDepartment("IT");
		dto.setSalary(233332.00);
		EmployeeDTO savedDto=employeeService.createEmployee(dto);
		assertNotNull(savedDto.getId());
		assertEquals("vivek",savedDto.getName());
	}
	
	@Test
	public void testGetEmployee() throws EmployeeNotFoundException {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setName("vivek");
		dto.setDepartment("IT");
		dto.setSalary(233332.00);
		EmployeeDTO savedDto=employeeService.createEmployee(dto);
		EmployeeDTO findemployeeById = employeeService.getEmployeeById(savedDto.getId());
		assertNotNull("vivek",findemployeeById.getName());
		assertEquals(savedDto.getId(),findemployeeById.getId());
		
	}
	
	@Test
	public void testUpdateEmployee() throws EmployeeNotFoundException {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setName("Ram");
		dto.setDepartment("Finance");
		dto.setSalary(45000.00);
		
		EmployeeDTO savedDto=employeeService.createEmployee(dto);
		
		EmployeeDTO updateDTO=new EmployeeDTO();
		updateDTO.setName("Rama");
		updateDTO.setDepartment("HR");
		updateDTO.setSalary(45000.00);
		
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(savedDto.getId(), updateDTO);
		assertEquals("Rama", updatedEmployee.getName());
		assertEquals("HR", updatedEmployee.getDepartment());
		assertEquals(Double.valueOf(45000.00),updatedEmployee.getSalary());
	}

	
	@Test
	public void testDeleteEmployee() throws EmployeeNotFoundException {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setName("Ram");
		dto.setDepartment("Finance");
		dto.setSalary(45000.00);
		
		EmployeeDTO savedDto=employeeService.createEmployee(dto);
		
		employeeService.deleteEmployee(savedDto.getId());
		
		try {
			employeeService.getEmployeeById(savedDto.getId());
			fail("Expected Employee Not found Exception....!!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
