package com.training.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
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

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject); // username
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	/*
	 * public static void main(String[] args) { System.out.println(new
	 * JwtUtil().generateToken("user1")); }
	 */
}










