package com.learnwebservices.learn.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwebservices.learn.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1, "Teste", "a@gmail.com", "(00)9999999", "pass123");
		return ResponseEntity.ok().body(u);
	}

}
