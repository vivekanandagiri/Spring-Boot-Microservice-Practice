package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
	
	
	private static final double INR_TO_USD=88.76;
	//convert INR to Dollar
	public double convertInrToDollar(Double amount) {
		double dollar=amount/INR_TO_USD;
		return dollar;
	}
	
	//Convert Dollar to INR
	public double convertDollarToInr(double amount) {
		double INR=amount*INR_TO_USD;
		return INR;
	}
	
}
