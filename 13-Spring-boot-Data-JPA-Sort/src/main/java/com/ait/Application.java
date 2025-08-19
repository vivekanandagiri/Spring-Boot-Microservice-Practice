package com.ait;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
			List<String>list=new ArrayList<>();
			list.add("vivek");
			list.add("Ram");
			list.add("Suman");
			list.add("Rajesh");
			int salary=9999;
			for(int i=0;i<4;i++) {
				EmployeeEntity employeeEntity=new EmployeeEntity();
				employeeEntity.setName(list.get(i));
				employeeEntity.setDept("HR");
				employeeEntity.setContactNo(7845554);
				employeeEntity.setSalary(salary);
				employeeEntity.setAddress("BBsr");
				salary++;
				
				//save
				repo.save(employeeEntity);
				}
			//Sorting  in default order of salary
			System.out.println("-------Sorting  in default order of salary--------");
				List<EmployeeEntity>all=repo.findAll(Sort.by("salary"));
				all.forEach(data->{
					System.out.println(data);
				});
			System.out.println("-------Sorting  in descending order of salary--------");
				
			List<EmployeeEntity>alldesc=repo.findAll(Sort.by(Sort.Direction.DESC,"salary"));
			alldesc.forEach(data->{
				System.out.println(data);
			});
			};
			
		
			
		
		//Sorting  in default order of salary
	}

}
