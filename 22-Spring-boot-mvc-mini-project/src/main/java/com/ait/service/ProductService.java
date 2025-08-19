package com.ait.service;

import java.util.List;

import com.ait.dto.ProductDTO;


public interface ProductService {
	public ProductDTO registerProduct (ProductDTO product);
	
	public ProductDTO updateProduct(ProductDTO product);
	
	public ProductDTO fetchProductById(Long id);
	
	public List<ProductDTO> fetchAllProduct(); 
	
	public ProductDTO deleteProduct(Long id);

}
