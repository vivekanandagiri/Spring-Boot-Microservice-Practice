package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
