//package com.khj.restapi05.config;
//
//import com.khj.restapi05.jwt.TokenManager;
//import com.khj.restapi05.member.Member;
//import com.khj.restapi05.member.MemberRepository;
//import com.khj.restapi05.member.Role;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jws;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.rmi.RemoteException;
//import java.util.List;
//import java.util.stream.Stream;
//
//@Component
//@RequiredArgsConstructor
//public class WebFilter extends OncePerRequestFilter {
//
//    private final TokenManager tokenManager;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("필터 동작");
//
//        String token = request.getHeader("Authorization");
//        String url = request.getRequestURI();
//
//        if(url.contains("login") || url.contains("join") || url.contains("token")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//
//        if(token == null || !token.startsWith("Bearer ")){
//            System.out.println("token이 없습니다.");
//            throw new RuntimeException("JWT 토큰 발행하세요.");
//        }
//
//        try {
//            Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer ".length()));
//
////            List<SimpleGrantedAuthority> roles = (List<SimpleGrantedAuthority>) jws.getBody().get("role");
//            List<SimpleGrantedAuthority> roles = Stream.of(jws.getPayload().get("role").toString())
//                    .map(SimpleGrantedAuthority::new)
//                    .toList();
//            System.out.println(roles);
//
//            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
//                    Member.builder()
//                            .email(jws.getPayload().get("email").toString())
//                            .username(jws.getPayload().get("username").toString())
//                            .id(jws.getPayload().get("id", Long.class))
//                            .role(Role.fromString(jws.getPayload().get("role").toString()))
//                            .build(),
//                    null,
//                    roles
//            );
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            filterChain.doFilter(request,response);
//
//        }catch (ExpiredJwtException e){
//            System.out.println("토큰 만료");
//            throw new RuntimeException("JWT 토큰 만료");
//        }
//        catch (Exception e){
//            System.out.println("토큰 검증 실패");
//            throw new RuntimeException("JWT 토큰 검증 실패");
//        }
//
//        filterChain.doFilter(request,response);
//    }
//}
