package com.infosys.service;

import org.springframework.stereotype.Service;

@Service
public class DTDCService {
	public DTDCService() {
		System.out.println("DTDCService.DTDCService()");
	}
	public void delivery(int orderId,String address) {
		System.out.println("DTDC.delivery()");
		System.out.println("order id: "+orderId+" delivered sucessfully and address is"+address);
	}

}
