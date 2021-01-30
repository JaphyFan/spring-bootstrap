package com.japhy.bootstrap.web.infrastructure.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/1/30 13:46
 */
@Component
@Slf4j
public class JwtUtil {

    private final String SECRET_KEY = "secret";
    private final String jwtIssuer = "example.io";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setIssuer(jwtIssuer).setClaims(claims).setSubject(subject)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (SignatureException ex) {
//            log.error("Invalid JWT signature - {}", ex.getMessage());
//        } catch (MalformedJwtException ex) {
//            log.error("Invalid JWT token - {}", ex.getMessage());
//        } catch (ExpiredJwtException ex) {
//            log.error("Expired JWT token - {}", ex.getMessage());
//        } catch (UnsupportedJwtException ex) {
//            log.error("Unsupported JWT token - {}", ex.getMessage());
//        } catch (IllegalArgumentException ex) {
//            log.error("JWT claims string is empty - {}", ex.getMessage());
//        }
//        return false;
    }

}
