package com.infosys.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.infosys.service.RBI;
@Primary
/// Here Used @Primary For the COnflict issue between HDFC and SBI because it is showing two beans 
@Service
public class Hdfc implements RBI {
	public Hdfc() {
		System.out.println("Hdfc::0-param Constructor");
	}
	
	@Override
	public void calculateIntrest(int principle, int time, int intrestRate) {
		intrestRate=(int)(intrestRate+6);
		double SimpleIntrest=(principle*time*intrestRate)/100;
		System.out.println("HDFC Intrest is:"+SimpleIntrest );

	}

}
