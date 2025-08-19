package com.ait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ait.component.ProductComponent;
import com.ait.entity.ProductEntity;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		ProductComponent bean = ctx.getBean(ProductComponent.class);
		
		//bean.createProduct();
		
		ProductEntity selectProductById = bean.selectProductById();
		System.out.println(selectProductById);
		
		ProductEntity updateProduct = bean.updateProduct();
		System.out.println(updateProduct);
		
		bean.deleteProductById();
		
		System.out.println("=========Fetching  all products============");
		bean.fetchAllProduct().forEach(data->{
			System.out.println(data);
		});
		
		System.out.println("===========Find product by name==========");
		String productNameToFind = "Samsung S25fe";
		bean.findProductByName(productNameToFind).forEach(data->{
			System.out.println(data);
		});
		
		
	}
	

}
