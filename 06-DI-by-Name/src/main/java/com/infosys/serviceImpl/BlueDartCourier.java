package com.infosys.serviceImpl;

import org.springframework.stereotype.Service;

import com.infosys.service.Courier;
@Service
public class BlueDartCourier implements Courier {
	
	public BlueDartCourier() {
		System.out.println("BlueDartCourier::0-Param Constructor");
	}

	@Override
	public void dehlivery(int orderId, String address) {
		System.out.println("Order Id: "+orderId+ "delivered to this location "+address+" through Bluedart Courier ");

	}

}
