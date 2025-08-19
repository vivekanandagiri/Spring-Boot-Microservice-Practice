package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
