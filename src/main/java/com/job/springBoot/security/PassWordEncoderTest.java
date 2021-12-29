package com.job.springBoot.security;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PassWordEncoderTest {
	private static PasswordEncoder passwordEncoder;
    
	private static void encode() {
	
		passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		String password = "password";
		String encPassword = passwordEncoder.encode(password);
		
		System.out.println(" password : " + password );
		System.out.println(" encPassword : " + encPassword ); 
		
		System.out.println("1. passwordEncoder.matches(password, encPassword); : " + passwordEncoder.matches(password, encPassword));
		System.out.println("2. (encPassword).contains(\"{bcrypt}\") : " + (encPassword).contains("{bcrypt}"));
	
	}
}
