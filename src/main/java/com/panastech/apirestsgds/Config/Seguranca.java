// package com.panastech.apirestsgds.Config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

// @Configuration
// @EnableWebSecurity
// public class Seguranca extends SecurityConfigurerAdapter{
    
//     @Bean
//     SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
//         return httpSecurity
//         .authorizeHttpRequests(
//             authorizeConfig ->{
//                 authorizeConfig.requestMatchers("/**").permitAll();
//             }
//         ).build();
//     }

// }
