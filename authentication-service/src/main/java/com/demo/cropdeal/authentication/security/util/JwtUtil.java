package com.demo.cropdeal.authentication.security.util;

import com.demo.cropdeal.authentication.model.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// utility class for jwt related methods
@Component
public class JwtUtil {
	@Value("${jwtSecretKey}")
	private String secretKey;
	
	private SecretKey getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public String getRoleFromToken(String token) {
		return getAllClaimsFromToken(token).get("role", String.class);
	}
	
	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		SecretKey signingKey = getSigningKey();
		return Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).getBody();
	}
	
	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	//generate token for user
	public String generateToken(Account account) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", account.getId());
		claims.put("role", account.getRoles());
		claims.put("name", account.getFullName());
		return doGenerateToken(claims, account.getUsername());
	}
	
	//while creating the token -
	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	//   compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		SecretKey signingKey = getSigningKey();
//		5 hours expiration time
		return Jwts.builder().setClaims(claims).setSubject(subject)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + (5 * 60 * 60 * 1000)))
			.signWith(signingKey, SignatureAlgorithm.HS256).compact();
	}
	
	//validate token
	public Boolean validateToken(String token, Account account) {
		final String username = getUsernameFromToken(token);
		final String roles = getRoleFromToken(token);
		
		return (username.equals(account.getUsername()) && account.getRoles().equals(roles) && !isTokenExpired(token));
	}
}
