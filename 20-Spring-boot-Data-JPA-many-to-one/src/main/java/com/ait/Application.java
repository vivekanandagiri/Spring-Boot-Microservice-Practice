package com.ait;



import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ait.entity.CategoryEntity;
import com.ait.entity.ProductEntity;
import com.ait.repository.CategoryRepository;
import com.ait.repository.ProductRepository;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 @Bean
	    public CommandLineRunner run(ProductRepository pRepo, CategoryRepository cRepo) {
	        return args -> {
	        	
	        	CategoryEntity categoryEntity=new CategoryEntity();
	        	categoryEntity.setName("Electronics");
	        	
	        	ProductEntity product1=new ProductEntity();
	        	product1.setName("Samsung Mobile");
	        	product1.setPrice(20000D);
	        	product1.setCategory(categoryEntity);
	        	
	        	ProductEntity product2=new ProductEntity();
	        	product2.setName("Sony Camera");
	        	product2.setPrice(70000D);
	        	product2.setCategory(categoryEntity);
	        	
	        	categoryEntity.getProducts().add(product1);
	        	categoryEntity.getProducts().add(product2);
	        	cRepo.save(categoryEntity);
	        	
	        	System.out.println("--- Displaying  Category and its Products ---");
	        	List<CategoryEntity> savedCategory = cRepo.findAll();
	        	savedCategory.forEach(data -> {
	                System.out.println("===category====");

	                System.out.println(data);
	                List<ProductEntity> products =data.getProducts(); 
	                System.out.println("===Products:====");
	                products.forEach(product -> {
	                	System.out.println(product);
	                }); 
 
	            });
	        	
	        	
	            
	        };
	    }
	}