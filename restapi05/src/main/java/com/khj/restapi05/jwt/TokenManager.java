package com.khj.restapi05.jwt;


import com.khj.restapi05.member.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${khj.jwt.secret}")
    private String mykey;

    public String generateToken(Member member){
        return Jwts.builder()
                .subject("khjToken")
                .claim("id",member.getId())
                .claim("username",member.getUsername())
                .claim("role",member.getRole())
                .claim("email",member.getEmail())
                // 유효시간 10시간
//                .expiration(new Date(System.currentTimeMillis() + 1000*60*60*10))
                // 유효시간 15분
                .expiration(new Date(System.currentTimeMillis() + 1000*60*15))
//                .expiration(new Date(System.currentTimeMillis() + 1000*60))
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }

    public Jws<Claims> validateToken(String  token){
        Jws<Claims> jws = Jwts.parser().setSigningKey(hmacShaKeyFor(mykey.getBytes()))
                .build()
                .parseClaimsJws(token);

        System.out.println(jws);

        return jws;
    }

}
