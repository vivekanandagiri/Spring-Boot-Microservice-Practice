package com.ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ait.entity.EmployeeEntity;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	//Print all Employee  (SQL Query==Select * from Employee)
	@Query("Select e from EmployeeEntity e")
	List<EmployeeEntity>getAllEmployee();
	//Salary
	@Query("SELECT e FROM EmployeeEntity e WHERE e.salary > :amount")
	List<EmployeeEntity> findBySalaryGreaterThan(@Param("amount") double amount);
	// Delete employee
	@Modifying
	@Transactional
	@Query("DELETE FROM EmployeeEntity e WHERE e.name = :name")
	int deleteByName(@Param("name") String name);
	//------------------------
	@Query("Select e from EmployeeEntity e where e.name=:name AND e.salary=:salary")
	List<EmployeeEntity>getEmployeeUsing(@Param("name")String name,@Param("salary")int salary);
	

}
