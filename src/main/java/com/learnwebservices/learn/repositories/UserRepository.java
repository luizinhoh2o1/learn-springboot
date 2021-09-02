package com.learnwebservices.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwebservices.learn.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
