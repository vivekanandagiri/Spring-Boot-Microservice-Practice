package com.ait;



import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ait.entity.EmployeeEntity;
import com.ait.repository.EmployeeRepository;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner loadDbRecords(EmployeeRepository repo) {
		return args->{
			


			int salary=9999;
			for(int i=0;i<100;i++) {
				EmployeeEntity employeeEntity=new EmployeeEntity();
				employeeEntity.setName("Vivek"+i);
				employeeEntity.setDept("HR");
				employeeEntity.setContactNo(7845554);
				employeeEntity.setSalary(salary);
				employeeEntity.setAddress("BBsr");
				salary++;
				repo.save(employeeEntity);
				
				}
			//Implementing Pagination
			
			for(int i=0;i<10;i++) {
			int pageSize=10;
			int pageNo=i;// Page index starts from 0 so it will display 1st page 
			//Creating the Pageable request with sorting
			Pageable pageable=PageRequest.of(pageNo, pageSize, Sort.by("id").ascending());
			//Fetching the page data 
			Page<EmployeeEntity>page=repo.findAll(pageable);
			
			System.out.println("/n--Displaying page "+(page.getNumber())+ " of "+page.getTotalPages()+"-----");
			//getting the list of employees from the page
			List<EmployeeEntity>pageEmployee=page.getContent();
			pageEmployee.forEach(data->{
				System.out.println(data);
			});
			//alternative method we can implement that "forEach(System.out::println);"
			System.out.println("\nTotal Employee: "+page.getTotalElements());
			System.out.println("Current page: "+page.getSize());
			}
			
		};
			
	}

}
