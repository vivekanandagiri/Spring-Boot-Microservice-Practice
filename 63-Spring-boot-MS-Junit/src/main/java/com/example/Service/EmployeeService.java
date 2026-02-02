package com.example.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.DTO.EmployeeDTO;
import com.example.Exception.EmployeeNotFoundException;


@Service
public class EmployeeService {
	
	private final Map<Long, EmployeeDTO> employee=new ConcurrentHashMap<>();
	private final AtomicLong counter=new AtomicLong();
	
	
	//Create
	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		
		Long id=counter.incrementAndGet();
		dto.setId(id);
		employee.put(id, dto);
		return dto;
	}
	
	//Fetch
	public EmployeeDTO getEmployeeById(Long id) throws EmployeeNotFoundException {
		EmployeeDTO employeeDTO = employee.get(id);
		if(employeeDTO==null) throw new EmployeeNotFoundException(id);
		return employeeDTO;
	}
	
	//fetch all
	public List<EmployeeDTO> getAllEmployee() {
		return new ArrayList<>(employee.values());
	}
	
	//Update
	public EmployeeDTO updateEmployee(Long id,EmployeeDTO dto) throws EmployeeNotFoundException {
		EmployeeDTO existing=employee.get(id);
		if(existing==null) {
			throw new EmployeeNotFoundException(id);
		}
		dto.setId(id);
		employee.put(id, dto);
		return dto;
	}
	//delete
	public void deleteEmployee(Long id) throws EmployeeNotFoundException {
		if(employee.remove(id)==null) {
			throw new EmployeeNotFoundException(id);
		}
		
	}

}
