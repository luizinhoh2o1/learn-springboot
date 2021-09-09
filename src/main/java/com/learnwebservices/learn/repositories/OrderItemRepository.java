package com.learnwebservices.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwebservices.learn.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
