package com.khj.mychart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing // entity 객체 생성시 시간 자동 생성 해줌
public class MychartApplication {

    public static void main(String[] args) {

		SpringApplication.run(MychartApplication.class, args);
    }

}
