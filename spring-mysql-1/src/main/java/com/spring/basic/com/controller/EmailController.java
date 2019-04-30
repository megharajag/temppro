package com.spring.basic.com.controller;

import javax.mail.MessagingException;

//com.spring.basic.com.controller.EmailController required a bean of type
//'org.springframework.mail.javamail.JavaMailSender
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class EmailController {

	@Autowired
	private JavaMailSender mailsender;
	
	@GetMapping("/sendMail")
	public String mail() throws MessagingException
	{
		SimpleMailMessage helper=new SimpleMailMessage();
		
		helper.setTo("megharaj5969@gmail.com");
		helper.setSubject("meghamail");
		helper.setText("Hi welcome");
		mailsender.send(helper);
		return "mail send successfuly";
		
	}
}
