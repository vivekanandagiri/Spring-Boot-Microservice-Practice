package com.ait.service;

import java.util.List;

import com.ait.entity.ProductEntity;

public interface ProductService {
	
	public ProductEntity saveProduct(ProductEntity product);
	
	public ProductEntity updateProduct(ProductEntity product);
	
	public void deleteProduct(Long id);
	
	public ProductEntity fetchProductById(Long id);
	
	public List<ProductEntity>fetchAllProduct();
	
	List<ProductEntity> findProductByName(String name);

}
