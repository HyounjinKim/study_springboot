package com.khj.portfolio.kakaologin;


import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    private String accessToken;
    private String refreshToken;
}
