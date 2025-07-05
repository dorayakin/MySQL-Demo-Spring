package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//		String rawPassword = "Password"; // エンコードしたい平文のパスワード
//		String encodedPassword = passwordEncoder.encode(rawPassword);
//		System.out.println(encodedPassword);
	}
}
