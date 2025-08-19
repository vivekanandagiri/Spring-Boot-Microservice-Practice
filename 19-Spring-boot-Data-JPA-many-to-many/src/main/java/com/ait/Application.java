package com.ait;



import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ait.entity.CourseEntity;
import com.ait.entity.StudentEntity;
import com.ait.repository.CourseRepository;
import com.ait.repository.StudentRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 @Bean
	    public CommandLineRunner run(StudentRepository sRepo, CourseRepository cRepo) {
	        return args -> {
	        	CourseEntity courseEntity=new CourseEntity();
	        	courseEntity.setTitle("Full Stack Java");
	        	CourseEntity courseEntity2=new CourseEntity();
	        	courseEntity2.setTitle("Spring Boot Microservice");
	        	
	        	cRepo.saveAll(List.of(courseEntity,courseEntity2));
	        	
	        	StudentEntity studentEntity=new StudentEntity();
	        	studentEntity.setName("Vivek");
	        	
	        	studentEntity.getCourse().add(courseEntity);
	        	studentEntity.getCourse().add(courseEntity2);
	        	
	        	
	        	StudentEntity studentEntity2=new StudentEntity();
	        	studentEntity2.setName("Ram");
	        	
	        	studentEntity2.getCourse().add(courseEntity);
	        	studentEntity2.getCourse().add(courseEntity2);
	        	
	        	sRepo.saveAll(List.of(studentEntity,studentEntity2));
	        	
	        	sRepo.findAll().forEach(data->{
	        		System.out.println(data.getCourse());
	        	});
	        	
	        	cRepo.findAll().forEach(data->{
					System.out.println(data.getStudents());
				});
	        	
	            
	        };
	    }
	}