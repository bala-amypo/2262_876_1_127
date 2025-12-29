package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers( "/").permitAll()
                .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                // Test endpoints for role verification
                .requestMatchers("/test/user").hasAnyRole("USER", "CUSTOMER", "AGENT", "ADMIN")
                .requestMatchers("/test/agent").hasAnyRole("AGENT", "ADMIN")
                .requestMatchers("/test/admin").hasRole("ADMIN")
                // Customer endpoints
                .requestMatchers("/complaints/submit").hasAnyRole("CUSTOMER", "USER", "ADMIN")
                .requestMatchers("/complaints/user/**").hasAnyRole("CUSTOMER", "USER", "AGENT", "ADMIN")
                // Agent/Admin endpoints
                .requestMatchers("/complaints/prioritized", "/complaints/status/**").hasAnyRole("AGENT", "ADMIN")
                // Admin only endpoints
                .requestMatchers("/rules/**").hasRole("ADMIN")
                // All other requests need authentication
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
