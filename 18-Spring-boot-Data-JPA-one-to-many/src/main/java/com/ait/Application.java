package com.ait;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ait.entity.DepartmentEntity;
import com.ait.entity.EmployeeEntity;

import com.ait.repository.DepartmentRepository;
import com.ait.repository.EmployeeRepository;





@SpringBootApplication
public class Application {

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 @Bean
	    public CommandLineRunner run(DepartmentRepository dRepo, EmployeeRepository eRepo) {
	        return args -> {
	            DepartmentEntity department = new DepartmentEntity();
	            
	            //1st dept
	            department.setDepartmentName("HR");
	            dRepo.save(department);
	            //2nd dept
	            DepartmentEntity department1 = new DepartmentEntity();
	            department1.setDepartmentName("Testing");
	            dRepo.save(department1);
	            //Emp info
	            EmployeeEntity emp1 = new EmployeeEntity();
	            emp1.setName("Vivek");
	            emp1.setDepartment(department);

	            EmployeeEntity emp2 = new EmployeeEntity();
	            emp2.setName("Rajesh");
	            emp2.setDepartment(department1);
	            eRepo.save(emp1);
	            eRepo.save(emp2);

	            System.out.println("--- Saved Department and Employees ---");
	            
	            DepartmentEntity savedDepartment = dRepo.findById(1L).orElse(null);
	            if (savedDepartment != null) {
	                System.out.println("\n--- Retrieved Department ---");
	                System.out.println("Department Name: " + savedDepartment.getDepartmentName());
	                System.out.println("Employees in this Department:");
	                savedDepartment.getEmployeeEntities().forEach(System.out::println);
	            }
	            DepartmentEntity savedDepartment1 = dRepo.findById(2L).orElse(null);
	            if (savedDepartment1 != null) {
	                System.out.println("\n--- Retrieved Department ---");
	                System.out.println("Department Name: " + savedDepartment1.getDepartmentName());
	                System.out.println("Employees in this Department:");
	                savedDepartment1.getEmployeeEntities().forEach(System.out::println);
	            }
	        };
	    }
	}