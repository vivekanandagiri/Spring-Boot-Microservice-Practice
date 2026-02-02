package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.EmployeeDTO;
import com.example.entity.EmployeeEntity;
import com.example.exception.EmployeeNotFoundException;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

//	@Override
//	public EmployeeDTO loginEmployee(String email, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EmployeeDTO findByEmail(String email) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public EmployeeDTO registerEmployee(EmployeeDTO employeeDTO) {
		return registerOrUpdate(employeeDTO);
	}
	//Method for both register and update
	public EmployeeDTO registerOrUpdate(EmployeeDTO employeeDTO) {
		EmployeeEntity entity=new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, entity);
		EmployeeEntity save=employeeRepository.save(entity);
		BeanUtils.copyProperties(save, employeeDTO);
		return employeeDTO;
	}

	
	

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		return registerOrUpdate(employeeDTO);
	}

	@Override
	public EmployeeDTO fetchEmployeeById(Long id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found with ID: " + id));
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity, dto);
		return dto;
	}

	@Override
	public List<EmployeeDTO> fetchAllEmployee() {
		List<EmployeeDTO>employeeDTO=new ArrayList<>();
		List<EmployeeEntity> allEmployee=employeeRepository.findAll();
		allEmployee.forEach(data->{
			 EmployeeDTO dto = new EmployeeDTO();
			 BeanUtils.copyProperties(data, dto);
			 employeeDTO.add(dto);
		});
		return employeeDTO;
	}

	@Override
	public EmployeeDTO deleteEmployee(Long id) {
		EmployeeEntity employeeToDelete = employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with ID: " + id + " for deletion."));
		employeeRepository.delete(employeeToDelete);
		return null;
	}
	

}
