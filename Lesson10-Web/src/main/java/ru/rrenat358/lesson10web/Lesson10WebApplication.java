package ru.rrenat358.lesson10web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Lesson10WebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Lesson10WebApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);






    }

}
