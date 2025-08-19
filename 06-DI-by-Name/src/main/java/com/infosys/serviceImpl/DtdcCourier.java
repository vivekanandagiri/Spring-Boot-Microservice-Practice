package com.infosys.serviceImpl;

import org.springframework.stereotype.Service;

import com.infosys.service.Courier;
@Service

public class DtdcCourier implements Courier {

	@Override
	public void dehlivery(int orderId, String address) {
		System.out.println("Order Id: "+orderId+ "delivered to this location "+address+" through Dtdc Courier ");


	}

}
