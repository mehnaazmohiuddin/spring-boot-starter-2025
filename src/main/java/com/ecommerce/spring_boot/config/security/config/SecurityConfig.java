package com.ecommerce.spring_boot.config.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity){
        try {
               httpSecurity.csrf(csrf->csrf.disable() ).authorizeHttpRequests((auth)-> {
                                                                                                 auth.requestMatchers("/user/login").permitAll().
                                                                                                         anyRequest().authenticated();
                                                                                             }
            );

            httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // JWT token filtering before username password.
            return httpSecurity.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
