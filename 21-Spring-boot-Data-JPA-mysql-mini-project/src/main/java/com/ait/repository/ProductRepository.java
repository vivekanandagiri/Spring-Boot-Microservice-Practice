package com.ait.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ait.entity.ProductEntity;
@Repository


public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
	
	@Query(value = "select * from product where name=?1	",nativeQuery = true)
	List<ProductEntity> findProductByName(String name);

}
