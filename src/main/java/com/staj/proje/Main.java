package com.staj.proje;

import com.staj.proje.controller.MainMenuController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.staj.proje.*")
@ComponentScan(basePackages = { "com.staj.proje.*" })
@EntityScan("com.staj.proje.*")
public class Main {


    public static void main(String[] args) {



        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);


        while(true){

        context.getBean(MainMenuController.class).printOperationsMenu();}
    }
}
