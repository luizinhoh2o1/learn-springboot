package com.learnwebservices.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwebservices.learn.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
