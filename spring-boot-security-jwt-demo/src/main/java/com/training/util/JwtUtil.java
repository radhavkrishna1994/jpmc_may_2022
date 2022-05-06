package com.training.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private String secretKey ="jwt123";
	
	public String generateToken(String username)
	{
		Map<String,Object> claims = new HashMap<>();
		claims.put("project_name", "bookstore");
		return createToken(claims,username);
	}

	public  String createToken(Map<String, Object> claims, String username) {
		
		String token = Jwts
		.builder()
		.setClaims(claims)
		.setSubject(username)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1))	
		.signWith(SignatureAlgorithm.HS256, secretKey)
		.compact();
		
		return token;
	}
	
	public static void main(String[] args) {
		System.out.println(new JwtUtil().generateToken("user1"));
	}
}










