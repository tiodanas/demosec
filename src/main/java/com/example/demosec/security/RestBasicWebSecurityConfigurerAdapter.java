package com.example.demosec.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class RestBasicWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationProviderService authenticationProviderService;

    @Autowired
    RestBasicAuthenticationEntryPoint restBasicAuthenticationEntryPoint;

/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProviderService);
//        auth.userDetailsService(userDetailsService);
    }
*/

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(restBasicAuthenticationEntryPoint)
                .and()
                .authenticationProvider(authenticationProviderService)
                .authorizeRequests().antMatchers("/h2/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
    }
}
