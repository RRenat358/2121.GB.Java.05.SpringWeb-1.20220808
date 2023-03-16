package ru.rrenat358.lesson10web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
//@Log4j
@SpringBootApplication
public class SpringWeb10 implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringWeb10.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8090/api/v1/user", String.class);
        log.info("Response: {}", response.getBody());
    }


}
