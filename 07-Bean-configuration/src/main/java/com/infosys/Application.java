package com.infosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.infosys.serviceImpl.Hdfc;
import com.infosys.serviceImpl.SBI;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run=SpringApplication.run(Application.class, args);
		Hdfc HdfcBean=run.getBean(Hdfc.class);
		Hdfc HdfcBean1=run.getBean(Hdfc.class);
		HdfcBean.calculateIntrest(100000, 2, 8);
		System.out.println("This is Singleton instance :"+(HdfcBean==HdfcBean1));
		SBI bean1=run.getBean(SBI.class);
//		SBI bean2=run.getBean(SBI.class);
		SBI bean3=run.getBean(SBI.class);
		System.out.println("This is Singleton instance :"+(bean1==bean3));
	}

}
