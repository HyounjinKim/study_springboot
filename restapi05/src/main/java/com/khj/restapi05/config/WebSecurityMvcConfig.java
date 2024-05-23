package com.khj.restapi05.config;


import com.khj.restapi05.main.member.MainMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityMvcConfig {

    private final MainMemberService mainMemberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.userDetailsService(mainMemberService);

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        http.formLogin(fr -> fr.loginPage("/main/login")
                .defaultSuccessUrl("/main/main")
                .successForwardUrl("/main/main")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/main/login?error"));

        http.logout(logout ->
                // 로그아웃 페이지 설정
                logout.logoutUrl("/main/logout")
                        // 로그아웃 성공시 갈 페이지
                        .logoutSuccessUrl("/main/main"));

        http
                .authorizeHttpRequests(
                        req -> req
                                .requestMatchers(
                                        "/main/login", "/main/login?error", "/main/join", "/error", "/main/main")
                                .permitAll().anyRequest().authenticated()
//                        req -> req.anyRequest().permitAll()
                );

        http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer
                .frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin()));

//        http.addFilter(filter);
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        // 유저 관리하는 매니저 클래스
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        // 로그인 할 수 있는 유저 생성
//        UserDetails userDetails = User.withUsername("user")
//                .password(passwordEncoder().encode("1234"))
//                .roles("USER")
//                .build();
//        // 유저관리 하는 매니저 클래스 유저 등록
//        userDetailsManager.createUser(userDetails);
//
//        // 유저관리 하는 매니저 IOC 컨테이너에 등록 -> securityConfig에서 사용
//        return userDetailsManager;
//    }

}
