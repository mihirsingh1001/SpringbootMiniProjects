package com.project.usermodule.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtility {

    private static final long TOKEN_VALIDITY = 10 * 60 * 60 * 1000;

    private static final String SECRET_KEY = "fbdkfbdkvbkvbkldfbvldfsbvsjfdbvkjfdbvlsfvbjfldvbsldvkfjvsbfdvbslfdvbdkjfhdskfj";

    public Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String token) {
        return Jwts.builder()
                .setSubject(token)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());

    }

    public Boolean valideToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }
}
