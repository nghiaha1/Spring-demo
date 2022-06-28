package com.spring.springordersecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("api/v1/account/products", "api/v1/login", "api/v1/account/register")
                .permitAll();
        http.authorizeRequests()
                .antMatchers("api/v1/users").hasAnyAuthority("user");
        http.authorizeRequests()
                .antMatchers( "api/v1/admins").hasAnyAuthority("admin");
    }
}
