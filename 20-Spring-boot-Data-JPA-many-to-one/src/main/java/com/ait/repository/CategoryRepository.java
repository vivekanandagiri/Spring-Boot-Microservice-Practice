package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
