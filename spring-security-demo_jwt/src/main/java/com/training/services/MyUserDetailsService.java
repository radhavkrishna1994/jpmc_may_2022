package com.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.model.MyUser;
import com.training.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		log.info("Entered loadUserByUserName...."+username);
		
		Optional<MyUser> opUser = userRepo.findById(username);
		
		
		
		if(opUser.isPresent())
		{
			MyUser myUser=opUser.get();
			
			/*
			 * String roleString = myUser.getRole(); // ROLE_USER,ROLE_ADMIN
			 * 
			 * List<SimpleGrantedAuthority> listRoles = new ArrayList<>();
			 * 
			 * String roles[] = roleString.split(",");
			 * 
			 * for(String role:roles) { listRoles.add(new SimpleGrantedAuthority(role)); }
			 */
			
			List<SimpleGrantedAuthority> listRoles1 =  
					Arrays.stream(myUser.getRole().split(","))
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());
			
			User user = new User(username, myUser.getPassword(), listRoles1);
			
			log.info("user details.."+myUser);
			return user;
		}
		
		return null;
	}

}
