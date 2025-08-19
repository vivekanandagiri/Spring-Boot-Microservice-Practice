package com.ait.component;

import java.time.LocalDate;
import java.util.List;

import com.ait.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ait.entity.ProductEntity;
import com.ait.service.ProductService;

@Component

public class ProductComponent {

    @SuppressWarnings("unused")
	private final ProductServiceImpl productServiceImpl;
	@Autowired
	private ProductService productService;

    ProductComponent(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }
	
	public ProductEntity createProduct() {
		ProductEntity entity=new ProductEntity();
		entity.setName("Samsung S25fe");
		entity.setModel("Galaxy S25fe");
		entity.setPrice("43000");
		entity.setMfd(LocalDate.now());
		entity.setWarranty(1);
		
		
		
		ProductEntity saveProduct = productService.saveProduct(entity);
		return saveProduct;
	}
	
	public ProductEntity selectProductById() {
		ProductEntity fetchProductById = productService.fetchProductById(2L);
		return fetchProductById;
	}
	public ProductEntity updateProduct() {
		ProductEntity entity=new ProductEntity();
		entity.setId(2L);//give id here for update
		entity.setName("Samsung S25fe");
		entity.setModel("Galaxy S25fe");
		entity.setPrice("43000");
		entity.setMfd(LocalDate.now());
		entity.setWarranty(1);
		
		
		
		ProductEntity saveProduct = productService.saveProduct(entity);
		return saveProduct;
	}
	
	public void deleteProductById() {
		productService.deleteProduct(303L);
	}
	
	public List<ProductEntity>fetchAllProduct(){
		List<ProductEntity> fetchAllProduct = productService.fetchAllProduct();
		return fetchAllProduct;
	}
	
	public List<ProductEntity> findProductByName(String productNameToFind) {
		List<ProductEntity> productByName = productService.findProductByName(productNameToFind);
		return productByName;
	}
	

}
