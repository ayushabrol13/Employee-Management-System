package com.bfb.emprepository.config;

import com.bfb.emprepository.services.impl.EmployeeDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final String[] WHITE_LIST_URLS = {"/hello", "/login", "/register", "/verifyRegistration*"};

    @Autowired
    private EmployeeDetailsServiceImpl employeeDetailsServiceImpl;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(employeeDetailsServiceImpl);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Lambda DSL: https://docs.spring.io/spring-security/reference/migration-7/configuration.html
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(WHITE_LIST_URLS).permitAll()
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers("/api/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(
//                .formLogin(login -> login
//                        .loginPage("/home/signin")
//                        .defaultSuccessUrl("/home/hello")
//                        .permitAll()
//                )
//                .rememberMe(Customizer.withDefaults())
//                .logout(logout -> logout
//                        .logoutUrl("/home/logout")
////                        .logoutSuccessUrl("/login")
//                        .permitAll()
                );

        http.authenticationProvider(daoAuthenticationProvider());
        return http.build();

//         http.cors().and().csrf().disable().authorizeHttpRequests().requestMatchers(WHITE_LIST_URLS).permitAll(); return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }
}
