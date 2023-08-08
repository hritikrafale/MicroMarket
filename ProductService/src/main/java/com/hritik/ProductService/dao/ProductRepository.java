package com.hritik.ProductService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hritik.ProductService.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
