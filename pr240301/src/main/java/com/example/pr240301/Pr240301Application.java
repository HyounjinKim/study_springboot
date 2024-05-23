package com.example.pr240301;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Pr240301Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Pr240301Application.class, args);

		String[] str = context.getBeanDefinitionNames();
		Arrays.stream(str).forEach(System.out::println);
	}

}
