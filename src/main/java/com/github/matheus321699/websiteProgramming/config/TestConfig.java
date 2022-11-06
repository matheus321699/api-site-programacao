package com.github.matheus321699.websiteProgramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.github.matheus321699.websiteProgramming.services.EmailService;
import com.github.matheus321699.websiteProgramming.services.MockEmailService;
import com.github.matheus321699.websiteProgramming.services.SmtpEmailService;

@Configuration
@Profile("teste")
public class TestConfig {

	@Bean
	public EmailService email() {
		return new MockEmailService();
	}
	
	@Bean
	@Primary
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
