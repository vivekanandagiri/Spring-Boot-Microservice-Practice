package com.ait.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.entity.ProductEntity;
import com.ait.repository.ProductRepository;
import com.ait.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		ProductEntity savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		ProductEntity updatedProduct = productRepository.save(product);
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);

	}

	@Override
	public ProductEntity fetchProductById(Long id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		return product.get();
	}

	@Override
	public List<ProductEntity> fetchAllProduct() {
		List<ProductEntity> allProduct =(List<ProductEntity>) productRepository.findAll();
		return allProduct;
	}
	@Override
    public List<ProductEntity> findProductByName(String name) {
        
        List<ProductEntity> productByName = productRepository.findProductByName(name);
		return productByName;
    }

}
