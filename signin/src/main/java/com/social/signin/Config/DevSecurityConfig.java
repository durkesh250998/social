// package com.social.signin.Config;

// import org.springframework.context.annotation.*;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class DevSecurityConfig {

//     @Bean
//     public SecurityFilterChain devSecurityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeHttpRequests()
//             .anyRequest().permitAll(); 
//         return http.build();
//     }
// }
