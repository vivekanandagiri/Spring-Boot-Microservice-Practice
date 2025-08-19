package com.infosys.serviceImpl;

import org.springframework.stereotype.Service;

import com.infosys.service.RBI;
@Service
public class SBI implements RBI {
	public SBI() {
		System.out.println("SBI:: 0-param Constructor");
	}

	@Override
	public void calculateIntrest(int principle, int time, int intrestRate) {
		intrestRate=(int)(intrestRate+4);
		double SimpleIntrest=(principle*time*intrestRate)/100;
		System.out.println("SBI Intrest is:"+SimpleIntrest);

	}

}
