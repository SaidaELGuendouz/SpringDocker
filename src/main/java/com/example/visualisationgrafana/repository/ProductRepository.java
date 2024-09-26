package com.example.visualisationgrafana.repository;

import com.example.visualisationgrafana.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
