package ru.rrenat358.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
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

    @Configuration
    public static class UiWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/**/*.css", "/**/*.js").permitAll()
                    .antMatchers("/").permitAll()
                    .antMatchers("/user/**").hasAnyRole("ADMIN", "SUPER_ADMIN")
                    .and()
                    .formLogin()
                    .successHandler((request, response, authentication) -> {
                        Set<String> auths = authentication.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toSet());
                        if (auths.contains("ROLE_ADMIN") || auths.contains("ROLE_SUPER_ADMIN")) {
                            response.sendRedirect("/user");
                        } else {
                            response.sendRedirect("/");
                        }
                    })
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/access_denied");

        }
    }

}
