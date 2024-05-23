package com.khj.mychart.kakao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://kapi.kakao.com" , name = "kakaoinfo")
public interface KakaoInfoClient {

    @GetMapping(value = "/v2/user/me",consumes = "application/json")

    KakaoProfileDto getKakaoInfo(            @RequestHeader("Content-Type") String contentType,
                                             @RequestHeader("Authorization") String accessToken);

}
