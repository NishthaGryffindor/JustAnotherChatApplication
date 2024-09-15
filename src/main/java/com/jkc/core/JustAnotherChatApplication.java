package com.jkc.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JustAnotherChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustAnotherChatApplication.class, args);
	}

}
