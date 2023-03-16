package ru.rrenat358.lesson10web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class Lesson10WebApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Lesson10WebApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("123");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8090/api/v1/user", String.class);

        log.info("Response: {}", response.getBody());

    }
}
