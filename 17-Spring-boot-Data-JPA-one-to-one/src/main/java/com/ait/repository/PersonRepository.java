package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
	

}
