package com.siweikongjian.feibonaqi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // (debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http//
                .authorizeRequests(authorizeRequests -> //
                authorizeRequests//
                        .antMatchers("/css/**", "/index/**", "/webjars/**", "/js/**", "/img/**").permitAll()//
                        .antMatchers(HttpMethod.POST, "/api/wx/**").permitAll()//
                        .antMatchers("/user/**").hasAnyAuthority("USER")//
                )//
                .formLogin(formLogin -> //
                formLogin//
                        .loginPage("/login")//
                        .failureUrl("/login-error")//
                );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

}
