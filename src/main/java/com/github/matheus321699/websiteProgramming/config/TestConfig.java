package com.github.matheus321699.websiteProgramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.matheus321699.websiteProgramming.services.EmailService;
import com.github.matheus321699.websiteProgramming.services.MockEmailService;

@Configuration
@Profile("teste")
public class TestConfig {

	@Bean
	public EmailService email() {
		return new MockEmailService();
	}
}
