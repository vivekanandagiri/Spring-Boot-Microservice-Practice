package com.example.service;

import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.stereotype.Service;

import com.example.DTO.EmployeeDTO;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Service
public class JaxBService {
//Marshaling
	public String marshalling(EmployeeDTO employee) throws JAXBException {
		//jaxb context
		JAXBContext jaxBInstance = JAXBContext.newInstance(EmployeeDTO.class);
		Marshaller marshaller = jaxBInstance.createMarshaller();
		
		//java object--> XML
		StringWriter writer = new StringWriter();
		marshaller.marshal(employee, writer);
		
		return writer.toString();
	}
	
//UnMarshalling	
	
	public EmployeeDTO unmarshall(String xml) throws JAXBException {
		JAXBContext jaxBInstance = JAXBContext.newInstance(EmployeeDTO.class);
		Unmarshaller unmarshaller = jaxBInstance.createUnmarshaller();
		
		StringReader reader=new  StringReader(xml);
		EmployeeDTO unmarshal = (EmployeeDTO) unmarshaller.unmarshal(reader);
		return unmarshal;
	}
	
}
