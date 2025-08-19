package com.infosys.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infosys.service.BlueDartService;
import com.infosys.service.DTDCService;
@Component
public class Flipkart {
	@Autowired
	private BlueDartService blueDartService;
	@Autowired
	private DTDCService dtdcService;
	//--------------Constructor Dependency Injection--------------
	public Flipkart(BlueDartService blueDartService) {
		System.out.println("Flipkart: constrctor...................");

		this.blueDartService=blueDartService;
	}
	//------------------Field Injection--------------
	
//	public Flipkart() {
//		System.out.println("Flipkart:O paramerterised");
//	}
//	@Autowired
//	public Flipkart(BlueDartService blueDartService, DTDCService dtdcService) {
//		System.out.println("Flipkart:Parameterised");
//		
//		this.blueDartService=blueDartService;
//		this.dtdcService=dtdcService;
//		
//	}
	
	//--------------------Setter Injection--------------------
	
	
	 @Autowired 
	 public void setBlueDartService(BlueDartService blueDartService) {
		 System.out.println("Setter injection is called");
		 this.blueDartService=blueDartService; 
	 }


	
	
	
	public void sendCourier(int orderId,String address,String courierPartner) {
		System.out.println("Flipkart.sendCourier()");
		if(courierPartner.equalsIgnoreCase("BLUEDART")) {
			blueDartService.delivery(orderId, address);
		}else {
			dtdcService.delivery(orderId, address);
		}

	}

}
