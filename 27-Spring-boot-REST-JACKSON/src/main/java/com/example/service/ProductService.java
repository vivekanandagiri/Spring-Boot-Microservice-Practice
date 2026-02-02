package com.example.service;

import org.springframework.stereotype.Service;

import com.example.DTO.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {
// java ---> JSON (Serialization)
	public String convertToJson(ProductDTO product) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(product);
		return json;
		
	}
// JSON ---> java (D-serialization)
	
	public ProductDTO convertToObject(String json) throws  JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ProductDTO product = mapper.readValue(json, ProductDTO.class);
		return product;
		
	}
}
