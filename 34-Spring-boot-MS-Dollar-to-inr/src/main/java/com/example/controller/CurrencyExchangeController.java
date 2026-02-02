package com.example.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ExchangeService;

@RestController
public class CurrencyExchangeController {
	private ExchangeService exchangeService;

	public CurrencyExchangeController(ExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}
	
	@GetMapping(value = "/inr-to-dollar/{amount}")
	public ResponseEntity<String>convertInrToDollar(@PathVariable double amount){
		double dollar = exchangeService.convertInrToDollar(amount);
		return ResponseEntity.ok("Converted INR:"+amount+" to Dollar"+dollar);
		
	}
	@GetMapping(value = "/dollar-to-inr/{amount}")
	public ResponseEntity<String>convertDollarToINR(@PathVariable double amount){
		double dollar = exchangeService.convertDollarToInr(amount);
		return ResponseEntity.ok("Converted Dollar:"+amount+" to INR"+dollar);
		
	}
}
