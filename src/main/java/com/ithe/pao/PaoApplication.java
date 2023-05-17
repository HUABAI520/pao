package com.ithe.pao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ithe.pao.mapper")
@EnableScheduling
public class PaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaoApplication.class, args);
    }

}

