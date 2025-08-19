package com.infosys.serviceImpl;

import org.springframework.stereotype.Service;

import com.infosys.service.Courier;
@Service("bluedartCourier")
public class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart::0-param Constructor");
	}

	@Override
	public void delivery(int orderId, String address) {
		System.out.println("order id: "+orderId+" deliverd on this location: "
                +address+" though courier partner is: BlueDart ");

	}

}
