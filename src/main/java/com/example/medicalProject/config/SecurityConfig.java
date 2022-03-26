package com.example.medicalProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //SecurityConfig가 스프링 필터체인에 등록된다.
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // @secured 활성화, @preAuthorize 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder PwdEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/doctor/**").access("hasRole('ROLE_DOCTOR') or hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll() // 페이지 접근 권한
                .and()
                .formLogin()
                .loginPage("/loginForm") //로그인 페이지
                .loginProcessingUrl("/login") //'login' 이라는 주소가 호출되면 시큐리티에서 로그인을 진행해 준다.
                .defaultSuccessUrl("/")//로그인 성공시 주소
                .and()
                .logout()
                .logoutSuccessUrl("/"); //로그아웃 성공시 주소
    }
}
