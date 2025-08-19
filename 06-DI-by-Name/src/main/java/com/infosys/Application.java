package com.infosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.infosys.util.Flipkart;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		//Take a bean of target class
		Flipkart flipkartBeanFlipkart=run.getBean(Flipkart.class);
		flipkartBeanFlipkart.sendCourier(101,"Bhubaneswar");

	}

}
