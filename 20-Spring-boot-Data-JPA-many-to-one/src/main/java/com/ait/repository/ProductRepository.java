package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
