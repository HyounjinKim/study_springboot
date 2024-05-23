package com.git.ex240223;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Ex240223Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ex240223Application.class,args);

		String str[] = context.getBeanDefinitionNames();

		for (String temp : str){
			System.out.println(temp);
		}

	}

}
