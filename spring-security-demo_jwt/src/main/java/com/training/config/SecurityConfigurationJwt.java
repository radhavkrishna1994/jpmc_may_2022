package com.training.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.training.filters.JwtFilter;
import com.training.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationJwt extends WebSecurityConfigurerAdapter  {
	Logger log = LoggerFactory.getLogger(SecurityConfigurationJwt.class);
	
	@Autowired
	private MyUserDetailsService userDetailsService;

	
	public PasswordEncoder getPasswordEncoder()
	{
		log.info("Inside Password Encoder");
		return new PasswordEncoder()
		{

			@Override
			public String encode(CharSequence rawPassword) {
				log.info("Inside Password Encode method");
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				log.info("Inside Password Encoder matches");
				return rawPassword.equals(encodedPassword);
			}

		};
	}

	//authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		log.info("Inside Configure authentication");
		
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
	}

	@Autowired
	private JwtFilter filter;
	//authorization
	public void configure(HttpSecurity http) throws Exception
	{
		
		log.info("Inside Configure Authorization");
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/authenticate")
		.permitAll()
		.antMatchers("/user/**")
		.hasRole("USER")
		//.hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**")
		.hasRole("ADMIN");
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

	}
	
	@Bean
	public AuthenticationManager auth() throws Exception
	{
		return super.authenticationManager();
	}



}
