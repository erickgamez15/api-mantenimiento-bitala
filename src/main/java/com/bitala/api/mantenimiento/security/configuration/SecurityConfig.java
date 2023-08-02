package com.bitala.api.mantenimiento.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        return http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authRequest -> authRequest.requestMatchers(
                    "/auth/**"
                ).permitAll()
                 .anyRequest()
                 .authenticated()
            )
            .formLogin(Customizer.withDefaults()
        ).build();
    }

}
