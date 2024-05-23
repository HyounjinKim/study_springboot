package com.git.ex03;

import com.git.ex03.component.BB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Ex03Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Ex03Application.class, args);

        String[] str = context.getBeanDefinitionNames();
        Arrays.stream(str).forEach(System.out::println);

    }

    @Bean
    public BB bb(){
        return new BB();
    }

}
