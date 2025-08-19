package com.ait.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ait.entity.EmployeeEntity;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	//Print all Employee  (SQL Query==Select * from Employee)
	@Query(value="Select * from Employee",nativeQuery = true)
	List<EmployeeEntity>getAllEmployee();
	Page<EmployeeEntity>findAll(Pageable pageable);
	//Salary
	@Query(value = "SELECT * FROM Employee e WHERE e.salary > :amount",nativeQuery = true)
	List<EmployeeEntity> findBySalaryGreaterThan(@Param("amount") double amount);
	// Delete employee
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM Employee e WHERE e.name = :name",nativeQuery = true)
	int deleteByName(@Param("name") String name);
	//------------------------
	@Query(value = "Select * from Employee e where e.name=:name AND e.salary=:salary",nativeQuery = true)
	List<EmployeeEntity>getEmployeeUsing(@Param("name")String name,@Param("salary")int salary);
	
	

}
