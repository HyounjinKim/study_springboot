package com.khj.mychart.kakao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoTokenClient kakaoTokenClient;
    private final KakaoInfoClient kakaoInfoClient;
    private String contentType = "Content-type: application/x-www-form-urlencoded;charset=utf-8";

    @Value("${kakao.client.id}")
    private String clientId;
    @Value("${kakao.client.secret}")
    private String clientSecret;
    @Value("${kakao.client.redirect}")
    private String redirect;

    public String getKakaoToken(String code){

        KakaoTokenDto.Requst kakaoTokenDtoRequest = KakaoTokenDto.Requst.builder()
                .grant_type("authorization_code")
                .client_id(clientId)
                .client_secret(clientSecret)
                .redirect_uri(redirect)
                .code(code)
                .build();

        KakaoTokenDto.Response resDto = kakaoTokenClient.getKakaoToken(contentType,kakaoTokenDtoRequest);
        System.out.println(resDto.getAccess_token());

        KakaoProfileDto kakaoProfileDto = kakaoInfoClient.getKakaoInfo(
                             contentType,
                "Bearer " + resDto.getAccess_token());
        System.out.println(kakaoProfileDto);

//        {
//            "id":3437460475,
//                "connected_at":"2024-04-15T03:25:58Z",
//                "properties":{"nickname":"������",
//                "profile_image":"http://t1.kakaocdn.net/account_images/default_profile.jpeg.twg.thumb.R640x640",
//                "thumbnail_image":"http://t1.kakaocdn.net/account_images/default_profile.jpeg.twg.thumb.R110x110"
//                },
//            "kakao_account":{"profile_nickname_needs_agreement":false,
//                "profile_image_needs_agreement":false,
//                "profile":{"nickname":"������",
//                "thumbnail_image_url":"http://t1.kakaocdn.net/account_images/default_profile.jpeg.twg.thumb.R110x110",
//                "profile_image_url":"http://t1.kakaocdn.net/account_images/default_profile.jpeg.twg.thumb.R640x640",
//                "is_default_image":true,"is_default_nickname":false
//                },
//            "has_email":true,"email_needs_agreement":false,"is_email_valid":true,
//                    "is_email_verified":true,"email":"hyoung6658@naver.com"}}

        return "getKakaoToken";
    }

}
