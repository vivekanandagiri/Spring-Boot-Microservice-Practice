package com.infosys.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.infosys.service.Courier;

@Component
public class Flipkart {

	
//	 @Autowired
//	 @Qualifier("dtdcCourier") private Courier courier;
//	 public Flipkart(@Qualifier("bluedartCourier") Courier courier) { this.courier
//	 = courier; }
	
	  @Autowired
	  @Qualifier("blueDartCourier")
	   private Courier blueDartCourier;

	
	  @Autowired
	  @Qualifier("dtdcCourier")
	   private Courier dtdcCourier;
	  
//	 @Autowired public void setCourier(@Qualifier("dtdcCourier") Courier courier)
//	  { this.courier = courier; }

	public void sendCourier(int i, String string) {
	
		blueDartCourier.dehlivery(i, string);
	}
	

}
