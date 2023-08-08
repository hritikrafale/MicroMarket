package com.hritik.ProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private double price;
	
	private int stockQuantity;
	
	public Product() {
		super();
	}

	public Product(Long productId, String name, String description, String category, double price, int stockQuantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", category="
				+ category + ", price=" + price + ", stockQuantity=" + stockQuantity + "]";
	}
}
