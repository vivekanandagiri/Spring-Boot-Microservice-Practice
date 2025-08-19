package com.infosys.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infosys.service.RBI;

@Component
public class IntrestCalculator {
	@Autowired
	RBI rbi;
	public void calculateIntrest(int principle,int time) {
		rbi.calculateIntrest(principle, time, 8);
	}
	
	

}
