package com.hritik.ProductService.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hritik.ProductService.model.Product;
import com.hritik.ProductService.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductService productService;

	// read all the products
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return ResponseEntity.ok(productList);
	}

	// read a product
	@GetMapping("/{productId}")
	public Optional<Product> getProductById(@PathVariable Long productId) {
		return productService.getProduct(productId);
	}

	// create a product
	@PostMapping("/")
	public Product postProduct(@RequestBody Product productData) {
		logger.info("Product ready to get saved in DB : " + productData.toString());
		return productService.saveProduct(productData);
	}

	// update a product
	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable Long productId, @RequestBody Product productData) {
		productData.setProductId(productId);
		return productService.saveProduct(productData);
	}

	// delete a product
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
		return "Product with ID " + productId + " is deleted sucessfully";
	}
}
