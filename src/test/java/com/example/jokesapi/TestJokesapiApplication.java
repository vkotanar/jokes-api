package com.example.jokesapi;

import org.springframework.boot.SpringApplication;

public class TestJokesapiApplication {

	public static void main(String[] args) {
		SpringApplication.from(JokesapiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
