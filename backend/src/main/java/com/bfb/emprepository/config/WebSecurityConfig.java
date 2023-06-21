package com.bfb.emprepository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final String[] WHITE_LIST_URLS = {"/login", "/register"};
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                 .cors()
                 .and()
                 .csrf()
                 .disable()
                 .authorizeHttpRequests()
                 .requestMatchers(WHITE_LIST_URLS).permitAll();
         return http.build();
//
//        // Lambda DSL: https://docs.spring.io/spring-security/reference/migration-7/configuration.html
////        http
////                .authorizeHttpRequests(authorize -> authorize
////                        .requestMatchers("/api/**").hasRole("ADMIN")
////                        .anyRequest().authenticated()
////                )
////                .formLogin(formLogin -> formLogin
////                        .loginPage("/login")
////                        .permitAll()
////                )
////                .rememberMe(Customizer.withDefaults());
////        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }
}
