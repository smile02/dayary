package com.inc.dayary;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration //자바에서 bean을 등록해주는 역할을 하려면 필요 (xml파일이라고 생각해야 함)
public class RootContext {
	
	@Bean
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("gosu12002@gmail.com");
		mailSender.setPassword("chwlrh12");
		
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.debug", "true");
		mailSender.setJavaMailProperties(props);
		
		return mailSender;
	}
}
