package com.khj.portfolio.kakaologin;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<Token> kakaologin(@RequestHeader String token){
        Token toekns = loginService.getToken(token);

        return ResponseEntity.status(HttpStatus.OK).body(toekns);
    }

    @GetMapping("/name")
    public ResponseEntity<String> kakaoname(@RequestHeader String token){
        String name = loginService.kakaoname(token);

        return ResponseEntity.status(HttpStatus.OK).body(name);
    }
}
