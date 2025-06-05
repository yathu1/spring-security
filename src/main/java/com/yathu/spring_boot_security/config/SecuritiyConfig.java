package com.yathu.spring_boot_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecuritiyConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz->
                authz .requestMatchers(HttpMethod.POST,"/api/users").permitAll()
                        .requestMatchers("/api/users/**").authenticated()
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
        )
        .formLogin(form ->
                form.permitAll().defaultSuccessUrl("/dashboard"))
                .csrf(csrf->csrf.disable());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager UserDetailsService(PasswordEncoder passwordEncoder) {
        // This method can be used to configure a custom UserDetailsService if needed
        // For now, we are using the default in-memory user details service provided by Spring Security
        UserDetails user= User.withUsername("yathu")
                .password(passwordEncoder.encode("123456")) // {noop} indicates that no password encoder is used
                .roles("USER")
                .build();

        UserDetails admin= User.withUsername("admin")
                .password(passwordEncoder.encode("123456")) // {noop} indicates that no password encoder is used
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
