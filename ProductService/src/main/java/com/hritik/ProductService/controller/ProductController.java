package com.hritik.ProductService.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	@GetMapping("")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return ResponseEntity.ok(productList);
	}

	// read a product
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
		Optional<Product> product = productService.getProduct(productId);
		return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// create a product
	@PostMapping("")
	public ResponseEntity<Product> postProduct(@RequestBody Product productData) {
		logger.info("Product ready to get saved in DB : " + productData.toString());
		Product product = productService.saveProduct(productData);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

	// update a product
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product productData) {
		if(!productService.ifProductExists(productId)) {
			return ResponseEntity.notFound().build();
		}
		
		productData.setProductId(productId);
		Product updatedProduct = productService.saveProduct(productData);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedProduct);
	}

	// delete a product
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
		if(!productService.ifProductExists(productId)) {
			return ResponseEntity.notFound().build();
		}
		
		productService.deleteProduct(productId);
		return ResponseEntity.ok("Product with ID " + productId + " is deleted sucessfully");
	}
}
