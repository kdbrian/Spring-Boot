package com.sec.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY="28472B6250655368566D5971337336763979244226452948404D635166546A";
	public String extractUsername(String jwt) {
		return extractClaim(jwt, Claims::getSubject);
		
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	//for if we are generating the token with the user details only
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(),userDetails);
	}
	
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 1000 * 24 * 60))
				.signWith(getSignInKey(), SignatureAlgorithm.HS256)
				.compact();
				
	}

	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	
	public boolean isTOkenValid(String token, UserDetails userDetails) {
		return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
	
	//checks if the token is expired
	private boolean isTokenExpired(String token) {
		// checking if the date of expiration of the token is before current date/time
		return extractExpiration(token).before(new Date(System.currentTimeMillis()));
	}

	//Extracts the expiration date of the token
	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	/***
	 * Generates a Key to be used to create the json web token
	 * @return
	 */
	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
}
