package com.hritik.ProductService.service;

import java.util.List;
import java.util.Optional;

import com.hritik.ProductService.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	
	public Optional<Product> getProduct(Long productID);
	
	public Product saveProduct(Product productData);
	
	public void deleteProduct(Long productID);
}
