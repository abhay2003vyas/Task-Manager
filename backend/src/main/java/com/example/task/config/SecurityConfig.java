package com.example.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.addAllowedOrigin("http://localhost:5173"); // Frontend origin
                config.addAllowedMethod("*"); // Allow all HTTP methods
                config.addAllowedHeader("*"); // Allow all headers
                config.setAllowCredentials(true); // Allow credentials
                return config;
            }))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/tasks/**", 
                    "/api/task/**"
                ).permitAll() // Public access for these routes
                .anyRequest().authenticated()); // Secure other endpoints
        
        return http.build(); // Finalize the SecurityFilterChain
    }
}
