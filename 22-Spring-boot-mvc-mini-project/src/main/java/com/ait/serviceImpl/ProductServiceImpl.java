package com.ait.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dto.ProductDTO;
import com.ait.entity.ProductEntity;
import com.ait.repository.ProductRepository;
import com.ait.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO registerProduct(ProductDTO product) {
		return registerOrUpdate(product);
		
	}
	
	//Method for both register and update
	public ProductDTO registerOrUpdate(ProductDTO product) {
		ProductEntity entity=new ProductEntity();
		BeanUtils.copyProperties(product, entity);
		ProductEntity save = productRepository.save(entity);
		BeanUtils.copyProperties(save, product);
		return product;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		return registerOrUpdate(product);
	}
	

	@Override
	public ProductDTO fetchProductById(Long id) {
		ProductDTO dto=new ProductDTO();
		Optional<ProductEntity>product = productRepository.findById(id);
		if(product.isPresent()) {
			BeanUtils.copyProperties(product.get(), dto);
		}
		return dto; 
	}

	@Override
	public List<ProductDTO> fetchAllProduct() {
		List<ProductDTO>products=new ArrayList<>();
		List<ProductEntity> allProduct = productRepository.findAll();
		allProduct.forEach(data->{
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(data, dto);
			products.add(dto);
		});
		return products;
	}

	@Override
	public ProductDTO deleteProduct(Long id) {
		productRepository.deleteById(id);
		return null;
	}

}
