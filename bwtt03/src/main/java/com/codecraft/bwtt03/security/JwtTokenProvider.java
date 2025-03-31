package com.codecraft.bwtt03.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;


import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenProvider {
    private final String jwtSecret = "YourSecretKey";
    private final long jwtExpirationInMs = 86400000;

    public String generateToken(UUID userId, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public UUID getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return UUID.fromString(claims.getSubject());
    }

    public boolean validateToken(String authToken){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }catch (JwtException | IllegalArgumentException exception){

        }
        return false;
    }
}
