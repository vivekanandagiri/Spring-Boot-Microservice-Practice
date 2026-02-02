package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.EmployeeDTO;
import com.example.entity.EmployeeEntity;
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
		EmployeeDTO dto = new EmployeeDTO();
		Optional<EmployeeEntity> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			BeanUtils.copyProperties(employee.get(), dto);
		}
		return dto;
	}

	@Override
	public List<EmployeeDTO> fetchAllEmployee() {
		List<EmployeeDTO>employee=new ArrayList<>();
		List<EmployeeEntity> allEmployee=employeeRepository.findAll();
		allEmployee.forEach(data->{
			 EmployeeDTO dto = new EmployeeDTO();
			 BeanUtils.copyProperties(data, dto);
			 employee.add(dto);
		});
		return employee;
	}

	@Override
	public EmployeeDTO deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return null;
	}
	

}
