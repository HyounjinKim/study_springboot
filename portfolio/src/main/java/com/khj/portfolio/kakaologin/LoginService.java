package com.khj.portfolio.kakaologin;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class LoginService {
    public Token getToken(String token) {

        MultiValueMap<String,String> bodys = new LinkedMultiValueMap<>();

        bodys.add("grant_type","authorization_code");
        bodys.add("client_id","94b443da7db84c565579d43ba563dd3f");
        bodys.add("redirect_uri","http://localhost:3000/auth");
        bodys.add("code",token);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type","application/x-www-form-urlencoded");

        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(bodys,headers);

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> responseEntity =
                template.exchange(
                        "https://kauth.kakao.com/oauth/token",
                        HttpMethod.POST,
                        entity, String.class);

        JSONObject jsonObject = new JSONObject(responseEntity.getBody());

        Token tokens = Token.builder()
                .accessToken(jsonObject.getString("access_token"))
                .refreshToken(jsonObject.getString("refresh_token"))
                .build();

        return tokens;
    }

    public String kakaoname(String token){

        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization","Bearer " + token);

        HttpEntity<String> entity = new HttpEntity(headers);

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> responseEntity =
                template.exchange("https://kapi.kakao.com/v2/user/me",
                        HttpMethod.GET,
                        entity, String.class);

        JSONObject jsonObject = new JSONObject(responseEntity.getBody());
        String kakaoAccount = jsonObject.get("kakao_account").toString();
        jsonObject = new JSONObject(kakaoAccount);
        String profile = jsonObject.get("profile").toString();
        JSONObject jsonProfile = new JSONObject(profile);

        return jsonProfile.get("nickname").toString();
    }
}
