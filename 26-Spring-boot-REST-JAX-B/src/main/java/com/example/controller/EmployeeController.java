package com.example.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.EmployeeDTO;
import com.example.service.JaxBService;

import jakarta.xml.bind.JAXBException;

@RestController
public class EmployeeController {
	@Autowired
	JaxBService jaxBService;
	
	@GetMapping(value = "/marshalling")
	public String marshal() throws JAXBException {
		EmployeeDTO employee = new EmployeeDTO(101, "Vivek", 100000.0, Arrays.asList("java","AWS"));
		String marshalling = jaxBService.marshalling(employee);
		return marshalling;
				}
		
	
	@GetMapping(value = "/unmarshalling")
	public EmployeeDTO unmarshall() throws JAXBException {
		String xml="<employee>\r\n"
				+ "    <id>101</id>\r\n"
				+ "    <name>Vivek</name>\r\n"
				+ "    <salary>100000.0</salary>\r\n"
				+ "    <skills>\r\n"
				+ "        <skills>java</skills>\r\n"
				+ "        <skills>AWS</skills>\r\n"
				+ "    </skills>\r\n"
				+ "</employee>";
		EmployeeDTO unmarshall = jaxBService.unmarshall(xml);
		System.out.println(unmarshall);
		return unmarshall;
	
	}}
