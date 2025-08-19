package com.infosys.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.infosys.service.Courier;
@Component
public class Flipkart {
	@Autowired
	@Qualifier("bluedartCourier") 
	private Courier courier;
	public Flipkart(@Qualifier("bluedartCourier")Courier courier) {
		this.courier=courier;
	}
	public void sendCourier(int orderId,String address) {
		courier.delivery(orderId, address);
	}

}
//Notes:: if one is used @Qualifier and top of that using @primary then it will prioritise the @Qualifier