package com.jantabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //combination of three annotation @Configuration/ @componentScan/ @EnableAutoconfiguration
public class BankingAppApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(BankingAppApplication.class, args);
	}

}
