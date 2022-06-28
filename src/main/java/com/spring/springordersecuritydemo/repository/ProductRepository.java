package com.spring.springordersecuritydemo.repository;

import com.spring.springordersecuritydemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
