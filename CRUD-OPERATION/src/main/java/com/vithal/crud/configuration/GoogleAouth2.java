/*
 * package com.vithal.crud.configuration;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration public class GoogleAouth2 {
 * 
 * 
 * @Bean public SecurityFilterChain chain(HttpSecurity httpSecurity) throws
 * Exception {
 * 
 * httpSecurity.authorizeHttpRequests().anyRequest().authenticated().and().
 * oauth2Login();
 * 
 * return httpSecurity.build();
 * 
 * }
 * 
 * }
 */