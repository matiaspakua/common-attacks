package com.matiaspakua.common_attacks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (not recommended in production)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/public/**").permitAll() // Public endpoints
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .formLogin(withDefaults()) // Enable form-based login
                .rememberMe(rememberMe -> rememberMe.key("uniqueAndSecret").tokenValiditySeconds(3600))
                .httpBasic(withDefaults()); // Enable basic HTTP authentication


        return http.build(); // Return SecurityFilterChain
    }
}
