package com.gr.bksafe.service.impl;

import com.gr.bksafe.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

/**
 * @Project: BKSafe_BE
 * @Author: sonle
 * @Date: 30/10/2023
 * @Time: 16:38
 */
@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.secret-key}")
    private String SECRET_KEY;
    @Value("${jwt.expiration-time}")
    private Integer EXPIRATION_TIME;

    @Override
    public boolean isValidToken(String token, UserDetails userDetails) {
        val username = extractUsername(token);
        return username.filter(userDetails.getUsername()::equals)
                .filter(user -> !isTokenExpired(token))
                .isPresent();
    }

    private boolean isTokenExpired(String token) {
        val expiration = extractExpiration(token);
        return expiration.before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    @Override
    public Optional<String> extractUsername(String token) {
        return Optional.ofNullable(extractClaim(token, Claims::getSubject));
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        var currentTimeMillis = System.currentTimeMillis();
        return Jwts
                .builder()
                .setClaims(new HashMap<>())
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        val claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        var bytes = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(bytes);
    }
}
