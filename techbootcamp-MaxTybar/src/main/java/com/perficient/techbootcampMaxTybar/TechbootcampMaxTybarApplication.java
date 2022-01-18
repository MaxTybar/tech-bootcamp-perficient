package com.perficient.techbootcampMaxTybar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechbootcampMaxTybarApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechbootcampMaxTybarApplication.class, args);
	}

	public int multiply(int a, int b) {
		return a * b;
	}

}
