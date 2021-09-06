package com.learnwebservices.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwebservices.learn.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
