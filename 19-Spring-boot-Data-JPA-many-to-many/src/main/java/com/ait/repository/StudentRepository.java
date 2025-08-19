package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	
}
