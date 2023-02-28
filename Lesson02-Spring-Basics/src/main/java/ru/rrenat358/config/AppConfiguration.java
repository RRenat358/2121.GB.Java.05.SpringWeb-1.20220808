package ru.rrenat358.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.rrenat358")
public class AppConfiguration {

    /*@Bean
    public ru.rrenat358.persist.UserRepository userRepository() {
        return new ru.rrenat358.persist.UserRepositoryImpl();
    }

    @Bean
    public ru.rrenat358.UserService userService(ru.rrenat358.persist.UserRepository userRepository) {
        return new ru.rrenat358.UserService(userRepository);
    }

    @Bean
    @Scope("prototype")
    public Cart cart() {
        return new Cart();
    }*/
}
