package com.learnwebservices.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwebservices.learn.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
