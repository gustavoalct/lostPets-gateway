package com.gateway;

import com.gateway.utils.security.AuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .configurationSource(request -> new CorsConfiguration()
                        .applyPermitDefaultValues());

        http.csrf().disable()
                .addFilterAfter(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/customer/login").permitAll()
                .antMatchers(HttpMethod.POST, "/accounts").permitAll()
                .antMatchers(HttpMethod.POST, "/accounts/login").permitAll()
                .antMatchers(HttpMethod.POST, "/accounts/resetPassword").permitAll()
                .antMatchers(HttpMethod.PATCH, "/coverages").permitAll()
                .anyRequest().authenticated();
    }
}
