package com.training.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.training.config.SecurityConfig;
import com.training.model.MyUser;
import com.training.repo.UserRepo;

public class MyUserDetailsService implements UserDetailsService {

	// username is one that is entered by the user on the form
	private Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("In MyUserDetailsService");
		//get the details
		Optional<MyUser> myUserOp = userRepo.findById(username);
		MyUser myUser=null;
		if(myUserOp.isPresent())
		{
			myUser=myUserOp.get();
			log.info("MyUser details:"+myUser);
		}
		
		
		return null;
	}

}
