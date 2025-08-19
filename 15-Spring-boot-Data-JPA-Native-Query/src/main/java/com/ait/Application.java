package com.ait;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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
				System.out.println("-------Printing all Employee JPQL--------");
				List<EmployeeEntity>allEmployee=repo.getAllEmployee();
						allEmployee.forEach(data->{
							System.out.println(data);
						});
				System.out.println("-------Find Salary Greater than ==Salary--------");
				List<EmployeeEntity>employeeSal=repo.findBySalaryGreaterThan(10000);
				employeeSal.forEach(data->{
					System.out.println(data);
				});
				System.out.println("-------Delete by employee name --------");
				int deletedCount = repo.deleteByName("vivek");
				System.out.println(deletedCount + " employees deleted.");
				System.out.println("-------details by  employee name and salary --------");
				List<EmployeeEntity>empDetails=repo.getEmployeeUsing("Ram",10000);
				System.out.println(empDetails);
				
				
				
				
			};
			
	}

}
