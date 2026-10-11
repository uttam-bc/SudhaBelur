package com.sudhabelur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhabelur.backend.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
