package com.naincy.SpringWebProject.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;


import java.time.Instant;
import java.nio.charset.StandardCharsets;

@Service
public class JWTUtil {

	@Value("${jwt.secret}")
	private String SECRET_KEY;

    private SecretKey getSignKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

  
    public String generateToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, 1000 * 60 * 60 * 10); 
    }

    
    private String buildToken(Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expirationMillis) {

Instant now = Instant.now();
Instant expiry = now.plusMillis(expirationMillis);

JwtBuilder builder = Jwts.builder()
.claims(extraClaims)
.subject(userDetails.getUsername())
.issuedAt(Date.from(now))
.expiration(Date.from(expiry))
.signWith(getSignKey(), Jwts.SIG.HS256); 

return builder.compact();
}

    
    
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    
    
    public Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    
    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

   
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

   
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractEmail(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
