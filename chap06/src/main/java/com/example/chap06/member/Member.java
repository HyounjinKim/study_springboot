package com.example.chap06.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Member {
    private String name;
    private int age;
}
