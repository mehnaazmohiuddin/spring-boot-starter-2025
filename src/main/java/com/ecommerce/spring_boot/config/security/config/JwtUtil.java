package com.ecommerce.spring_boot.config.security.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {
    private final String SECRET_KEY;
    byte[] keyBytes;
    Key key ;

    public  JwtUtil(  @Value("${security.jwt.signing_password}") String secretKeyFromEnv) {
        System.out.println("the value is coming null secretKeyFromEnv = "+secretKeyFromEnv );
        SECRET_KEY = secretKeyFromEnv;
        keyBytes = SECRET_KEY.getBytes();
        key = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }
    public String  generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .claim("ROLES",roles)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256,key )
                .compact();
    }

    public  String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
