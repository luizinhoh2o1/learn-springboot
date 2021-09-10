package com.learnwebservices.learn.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learnwebservices.learn.entities.Category;
import com.learnwebservices.learn.entities.Order;
import com.learnwebservices.learn.entities.OrderItem;
import com.learnwebservices.learn.entities.Payment;
import com.learnwebservices.learn.entities.Product;
import com.learnwebservices.learn.entities.User;
import com.learnwebservices.learn.entities.enums.OrderStatus;
import com.learnwebservices.learn.repositories.CategoryRepository;
import com.learnwebservices.learn.repositories.OrderItemRepository;
import com.learnwebservices.learn.repositories.OrderRepository;
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
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Category c1 = new Category(null, "Limpeza");
		Category c2 = new Category(null, "Eletronicos");
		
		Product p1 = new Product(null, "Sabonete", "Uso geral. Limpa tudo!", 2.0, "www.sabonete.com");
		Product p2 = new Product(null, "Água sanitária", "Uso geral.", 5.50, "www.qboa.com");
		Product p3 = new Product(null, "Álcool", "Proibido venda para menores de 18!", 4.25, "www.alcool.com");
		Product p4 = new Product(null, "CPU", "4 nucleos, 3.1Ghz", 300.0, "www.cpu.com");
		Product p5 = new Product(null, "Teclado", "Mecanico, ABNT2", 500.0, "www.keyboard.com");
		Product p6 = new Product(null, "Mouse", "5000DPI, 7 botões", 150.0, "www.mousegamer.com");
		
		p1.getCategories().add(c1);
		p2.getCategories().add(c1);
		p3.getCategories().add(c1);
		p4.getCategories().add(c2);
		p5.getCategories().add(c2);
		p6.getCategories().add(c2);
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		Payment pay1 = new Payment(null, Instant.parse("2019-07-22T22:23:22Z"), o1);
		o1.setPayment(pay1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}
	
}
