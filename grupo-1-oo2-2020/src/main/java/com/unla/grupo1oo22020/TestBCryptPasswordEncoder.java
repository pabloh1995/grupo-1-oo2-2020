package com.unla.grupo1oo22020;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptPasswordEncoder {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder(4);
		System.out.println(pass.encode("admin"));
	}

}
