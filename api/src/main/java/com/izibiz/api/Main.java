package com.izibiz.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories(basePackages = {"com.izibiz.repository.*"})
@ComponentScan(basePackages = { "com.izibiz.*" })
@EntityScan(basePackages = {"com.izibiz.repository.entity"})


public class Main {


    public static void main(String[] args) {



        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

    }
}
