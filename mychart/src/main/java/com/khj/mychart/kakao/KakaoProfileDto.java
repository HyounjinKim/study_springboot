package com.khj.mychart.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.khj.mychart.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class KakaoProfileDto {

    private String id;

    @JsonProperty("kakao_account")
    private KakaoAccount kakao_account;

    public Member toMember(){

        return Member.builder()
                .email(kakao_account.email)
                .nickname(kakao_account.getProfile().getNickname())
                .profileImageUrl(kakao_account.getProfile().getProfileImage())
                .thumbnailImageUrl(kakao_account.getProfile().getThumbnailImage())
                .build();
    }

    @Data
    public static class KakaoAccount {
        private String email;
        private Profile profile;

        @Data
        public class Profile{
            @JsonProperty("nickname")
            private String nickname;

            @JsonProperty("profile_image_url")
            private String profileImage;
            @JsonProperty("thumbnail_image_url")
            private String thumbnailImage;
        }

    }
}
