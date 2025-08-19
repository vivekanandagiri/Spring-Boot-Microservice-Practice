package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.service.WishGeneratorService;

@SpringBootApplication
public class WishGeneratorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(WishGeneratorApplication.class, args);
		WishGeneratorService wishGeneratorServiceBean=run.getBean(WishGeneratorService.class);
		
		
		wishGeneratorServiceBean.WishGenerator();
		
	}

}
