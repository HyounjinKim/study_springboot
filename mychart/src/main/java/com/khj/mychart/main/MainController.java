package com.khj.mychart.main;


import com.khj.mychart.kakao.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final KakaoService kakaoService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/container")
    public String container(){
        return "container";
    }
    @GetMapping("oauth/kakao/callback")
    public String kakao(String code){
        kakaoService.getKakaoToken(code);
        String redirectTo = "http://localhost:3000";

        return "redirect:" + redirectTo;
    }
}
