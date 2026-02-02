package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.CurrencyExchangeClient;

@RestController
public class CurrencyConversionController {
	
	private final CurrencyExchangeClient exchangeClient;

	public CurrencyConversionController(CurrencyExchangeClient exchangeClient) {
		this.exchangeClient = exchangeClient;
	}
	@GetMapping(value = "/inr-to-dollar/{amount}")
	public ResponseEntity<String>convertInrToDollar(@PathVariable double amount){
		String msg = exchangeClient.getInrToDollar(amount);
		return ResponseEntity.ok(msg);
		
	}
	@GetMapping(value = "/dollar-to-inr/{amount}")
	public ResponseEntity<String>convertDollarToINR(@PathVariable double amount){
		String msg = exchangeClient.getDollarToInr(amount);
		return ResponseEntity.ok(msg);
		
	}

}
