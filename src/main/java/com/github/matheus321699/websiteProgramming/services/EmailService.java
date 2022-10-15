package com.github.matheus321699.websiteProgramming.services;

import org.springframework.mail.SimpleMailMessage;

import com.github.matheus321699.websiteProgramming.domain.Users;

public interface EmailService {
	
	void sendRegistrationConfirmationEmail(Users obj);
	
	void sendEmail(SimpleMailMessage msg);


}
