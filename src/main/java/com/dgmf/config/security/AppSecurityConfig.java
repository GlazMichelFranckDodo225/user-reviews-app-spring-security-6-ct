package com.dgmf.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        // httpSecurity.csrf(csrf -> csrf.disable())
        httpSecurity.csrf(AbstractHttpConfigurer::disable) // Returns the
                // HttpSecurityBuilder for additional customizations
                .authorizeHttpRequests(
                    authorize ->
                            authorize
                                    .requestMatchers(POST,"/registration")
                                    .permitAll()
                                    .anyRequest().authenticated()
                );

        return httpSecurity.build();
    }
}
