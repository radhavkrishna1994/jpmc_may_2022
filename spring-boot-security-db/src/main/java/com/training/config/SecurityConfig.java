package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		log.info("Authentication");
		
		auth
		.inMemoryAuthentication()
		.withUser("user1")
		.password("{noop}user1")
		.roles("USER")
		.and()
		.withUser("admin1")
		.password("{noop}admin1")
		.roles("ADMIN");
	}
		
	//Authorization
	public void configure(HttpSecurity http) throws Exception
	{
		log.info("In Authorization....");
		
		http
		.authorizeRequests()
		.antMatchers("/user/**")
		//.hasRole("USER")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.and().formLogin();
		
	}
	
}
