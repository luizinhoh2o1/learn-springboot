package com.learnwebservices.learn.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learnwebservices.learn.entities.Category;
import com.learnwebservices.learn.entities.Product;
import com.learnwebservices.learn.entities.User;
import com.learnwebservices.learn.repositories.CategoryRepository;
import com.learnwebservices.learn.repositories.ProductRepository;
import com.learnwebservices.learn.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Category c1 = new Category(null, "Limpeza");
		Category c2 = new Category(null, "Eletronicos");
		
		Product p1 = new Product(null, "Sabonete", "Uso geral. Limpa tudo!", 2.0, "www.sabonete.com", c1);
		Product p2 = new Product(null, "Água sanitária", "Uso geral.", 5.50, "www.qboa.com", c1);
		Product p3 = new Product(null, "Álcool", "Proibido venda para menores de 18!", 4.25, "www.alcool.com", c1);
		Product p4 = new Product(null, "CPU", "4 nucleos, 3.1Ghz", 300.0, "www.cpu.com", c2);
		Product p5 = new Product(null, "Teclado", "Mecanico, ABNT2", 500.0, "www.keyboard.com", c2);
		Product p6 = new Product(null, "Mouse", "5000DPI, 7 botões", 150.0, "www.mousegamer.com", c2);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
	}
	
}
