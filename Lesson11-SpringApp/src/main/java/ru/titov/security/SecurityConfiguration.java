package ru.titov.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    public void authConfig(
            AuthenticationManagerBuilder authBuilder,
            UserDetailsServiceImpl userDetailsService,
            PasswordEncoder encoder
    ) throws Exception {
        authBuilder.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN")
                .and()
                .withUser("guest")
                .password(encoder.encode("guest"))
                .roles("GUEST");

        authBuilder.userDetailsService(userDetailsService);
    }

}
