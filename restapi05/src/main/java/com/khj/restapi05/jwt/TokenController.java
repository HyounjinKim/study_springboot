package com.khj.restapi05.jwt;


import com.khj.restapi05.member.Member;
import com.khj.restapi05.member.MemberRepository;
import com.khj.restapi05.member.Role;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenManager tokenManager;
    private final MemberRepository memberRepository;

    @GetMapping("/auth")
    public String loginTest(Authentication authentication){

        System.out.println(authentication);
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        return "loginTest";
    }

    @PostMapping("/token")
    public String token(@RequestBody TokenDto tokenDto) {
        System.out.println("email = " + tokenDto.getEmail());
        System.out.println("password = " + tokenDto.getPassword());
        Member dbmember = memberRepository.findByEmailAndPassword(tokenDto.getEmail(), tokenDto.getPassword());

        if (dbmember == null) {
            throw new RuntimeException("회원가입이 안되어있습니다.");
        }
        return tokenManager.generateToken(dbmember);

    }

    @GetMapping("/valid")
    public String valid(HttpServletRequest request){
        String auth = request.getHeader("Authorization");
        System.out.println(auth);

//        tokenManager.validateToken("eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJraGpUb2tlbiIsImlkIjoxLCJ1c2VybmFtZSI6Iu2Zjeq4uOuPmSIsInJvbGUiOiJVU0VSIiwiZW1haWwiOiJhYWFAbmF2ZXIuY29tIiwiZXhwIjoxNzEwOTgzMzY1fQ.15zUauVIMn6Jc5uK9n6JKuWur6X8i2s58KHHb12YY1v2YBypLDUX8tpGZcqMWfx_");
        return "!!!!";
    }
}
