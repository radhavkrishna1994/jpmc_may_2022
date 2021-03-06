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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	private Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		log.info("Authentication");
		
		auth
		.userDetailsService(myUserDetailsService)
		.passwordEncoder(getPasswordEncoder());
	
		
	}
		
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		log.info("In Password Encoder..");
		PasswordEncoder encoder = new PasswordEncoder()
				{
					@Override
					public String encode(CharSequence rawPassword) {
						
						log.info("In Password Encoder Encode..");
						return rawPassword.toString();
					}

					@Override
					public boolean matches(CharSequence rawPassword, String encodedPassword) {
						log.info("In Password Encoder Matches..");
						return rawPassword.equals(encodedPassword);
					}
			
				};
		
		return encoder;
	}

	@Autowired
	private JwtFilter jwtFilter;
	
	//Authorization
	public void configure(HttpSecurity http) throws Exception
	{
		log.info("In Authorization....");
		
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/authenticate")
		.permitAll()
		.antMatchers("/user/**")
		//.hasRole("USER")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.anyRequest()
		.authenticated();
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	public AuthenticationManager authManager() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
