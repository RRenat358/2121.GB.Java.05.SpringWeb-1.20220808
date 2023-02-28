package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.rrenat358.persist.UserRepository;
import ru.rrenat358.persist.UserRepositoryImpl;

@Configuration
@ComponentScan("ru.rrenat358")
public class AppConfiguration {

    /*@Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    @Scope("prototype")
    public Cart cart() {
        return new Cart();
    }*/
}
