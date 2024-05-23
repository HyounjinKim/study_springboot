package com.example.pr240301.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void regist(Member member){
        memberRepository.insert(member);
    }

    public void select(){
        Collection<Member> map = memberRepository.select();

        map.forEach(System.out::println);
    }

    public void save(Member member) {
        memberRepository.save(member);
    }
}
