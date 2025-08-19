package com.ait;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ait.entity.StudentEntity;
import com.ait.repository.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
@Bean
@Transactional
public CommandLineRunner loadDbRecords(StudentRepository repo) {
	return args->{
		
		//Create Operation
		for(int i=0;i<50;i++) {
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setId(0);
		studentEntity.setName("Vivek_"+i);
		studentEntity.setStream("Mechanical");
		studentEntity.setAddress("Bbsr");
		studentEntity.setContactNo((long) 907828565);
		
		//save
		repo.save(studentEntity);
		}
		//Another record 
//		StudentEntity studentEntity1=new StudentEntity();
//		studentEntity1.setId(0);
//		studentEntity1.setName("Rajesh");
//		studentEntity1.setStream("Electrical");
//		studentEntity1.setAddress("Bbsr");
//		studentEntity1.setContactNo((long) 907823225);
//		
//		//save
//		repo.save(studentEntity1);
		
		//Retrieval Operation/Fetch Data
		 List<StudentEntity>allStudent=  repo.findAll();
		 allStudent.forEach(data->{
			 System.out.println(data);
		 }
		 );
		//Delete Record:
		 //repo.deleteById(32);
//--------------------------------------
		//Fetch the record with student name 
		 repo.findByName("vivek_4");
		//Fetch the record with student name and contactNo
//		 repo.findByNameAndContactNo("vivek_3", 907828566);		
		 System.out.println("-----------Greater Than -----------");
		 //Greater than
		 List<StudentEntity> results = repo.findByIdGreaterThan(45);
		 results.forEach(System.out::println);

		 //Less than
		 System.out.println("----------Less than------------");
		 List<StudentEntity> results1 = repo.findByIdLessThan(5);
		 results1.forEach(System.out::println);
		 //
         // --- 3. Delete a record by name ---
		 System.out.println("\n--- Flushing data to database... ---");
         repo.flush();
         String nameToDelete = "Vivek_1";
         System.out.println("--- Deleting student by name: " + nameToDelete + " ---");
         repo.deleteByName(nameToDelete);

         // --- 4. Verify the final data ---
         System.out.println("--- Final list of students: ---");
         repo.findAll().forEach(System.out::println);
         // --- 3. Delete a record by name ---
         
         //repo.deleteByStream("Mechanical");
		 
	};
}
}
