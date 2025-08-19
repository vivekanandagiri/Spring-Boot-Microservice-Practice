package com.infosys.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.infosys.service.Courier;
@Service("dtdcCourier")
@Primary
public class DTDC implements Courier {
	public DTDC() {
		System.out.println("BlueDart::0-param Constructor");
	}

	@Override
	public void delivery(int orderId, String address) {
		System.out.println("order id: "+orderId+" deliverd on this location: "
                +address+" though courier partner is: DTDC ");
	}

}
