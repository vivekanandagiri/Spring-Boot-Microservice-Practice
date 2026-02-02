package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ProductDTO;
import com.example.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@GetMapping(value = "/to-json")
	public String generateJson() throws JsonProcessingException {
		ProductDTO product = new ProductDTO(101,"iphone 17",170000,"Apple");
		String convertToJson = productService.convertToJson(product);
		return convertToJson;
		
	}
	@GetMapping (value = "/to-object")
	public ProductDTO generateObject() throws JsonProcessingException {
		String json="{\r\n"
				+ "    \"id\": 2554,\r\n"
				+ "    \"name\": \"TV\",\r\n"
				+ "    \"price\": 170000.0,\r\n"
				+ "    \"brand\": \"Samsung\"\r\n"
				+ "}";
		ProductDTO convertToObject = productService.convertToObject(json);
		System.out.println(convertToObject);
		return convertToObject;
		
	}

}
