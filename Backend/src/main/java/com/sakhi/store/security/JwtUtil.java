package com.sakhi.store.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${app.jwt.secret}")
    private String secret;
    @Value("${app.jwt.expirationMs}")
    private long expirationMs;

    private SecretKey getKey() { return Keys.hmacShaKeyFor(secret.getBytes()); }

    public String generateToken(String subject) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);
        return Jwts.builder().setSubject(subject).setIssuedAt(now).setExpiration(exp)
                .signWith(getKey(), SignatureAlgorithm.HS256).compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try { Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token); return true; }
        catch (JwtException ex) { return false; }
    }
}
