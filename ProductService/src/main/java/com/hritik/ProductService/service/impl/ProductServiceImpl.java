package com.hritik.ProductService.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hritik.ProductService.dao.ProductRepository;
import com.hritik.ProductService.model.Product;
import com.hritik.ProductService.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	//read all the products
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	//read a product
	@Override
	public Optional<Product> getProduct(Long productId) {
		return productRepository.findById(productId);
	}
	
	//create a product
	@Override
	public Product saveProduct(Product productData) {
		return productRepository.save(productData);
	}

	//delete a product
	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);;
	}

	// check if product with given id exists
	@Override
	public boolean ifProductExists(Long productId) {
		return productRepository.existsById(productId);
	}
}
