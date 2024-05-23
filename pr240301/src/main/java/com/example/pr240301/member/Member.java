package com.example.pr240301.member;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Member {
    private String id;
    private String title;
    private String pw;
    private String content;
}
