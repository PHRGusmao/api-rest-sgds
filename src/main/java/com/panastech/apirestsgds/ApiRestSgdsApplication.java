package com.panastech.apirestsgds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiRestSgdsApplication {

	public static void main(String[] args) {
		Thread spring = new Thread(() ->{
			SpringApplication.run(ApiRestSgdsApplication.class, args);
		});
		spring.start();
	}

}
