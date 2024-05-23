package com.khj.mychart.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void name(){
        for(int i = 0; i < 100;i++){
            memberRepository.save(Member.builder()
                    .email("ccc" + i + "@naver.com")
                    .nickname("ccc" + i)
                    .build());
        }
        System.out.println("test");
    }
}