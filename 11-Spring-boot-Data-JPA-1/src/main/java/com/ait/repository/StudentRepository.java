package com.ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ait.entity.StudentEntity;

import jakarta.transaction.Transactional;
@Transactional
@Repository

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	//Fetch the record with student name 
	public StudentEntity findByName(String name);
	//Fetch the record with student name and contactNo
	
	public StudentEntity findByNameAndContactNo(String name,int ContactNO );
	//3 parameter 
	public StudentEntity findByNameAndContactNoAndAddress(String name,int ContactNO ,String address);
	//Greater than

	public List<StudentEntity> findByIdGreaterThan(int i);
	
	//Less Than
	public List<StudentEntity> findByIdLessThan(int i);
	//Delete by name 
	
	 void deleteByName(String name);
	//Delete by stream
	 void deleteByStream(String stream);

	

}
