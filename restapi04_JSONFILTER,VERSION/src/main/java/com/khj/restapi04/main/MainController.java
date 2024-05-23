package com.khj.restapi04.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${jasypt.encryptor.password}")
    String password;

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @PostMapping("greet")
    public String greet(String param){
        return "greet " + param;
    }

    @GetMapping("/password")
    public String password(){
        return password;
    }
}
