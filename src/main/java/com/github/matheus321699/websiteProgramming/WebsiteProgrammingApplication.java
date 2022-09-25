package com.github.matheus321699.websiteProgramming;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.matheus321699.websiteProgramming.domain.Users;
import com.github.matheus321699.websiteProgramming.repositories.UserRepository;

@SpringBootApplication
public class WebsiteProgrammingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WebsiteProgrammingApplication.class, args);
	}
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Users user1 = new Users(null, "Ney", "ney@gmail.com");
		Users user2 = new Users(null, "Messi", "messi@gmail.com");
		Users user3 = new Users(null, "Junior", "Junior@gmail.com");
		Users user4 = new Users(null, "Ronaldo", "ronaldo@gmail.com");

		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
		
	}

}
