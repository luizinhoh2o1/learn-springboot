package com.learnwebservices.learn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnwebservices.learn.entities.Product;
import com.learnwebservices.learn.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Product> findByCategory(Long id) {
		return findAll().stream().filter((product) -> {
			return product.getCategory().getId().equals(id); 
		}).toList();
	}
}
