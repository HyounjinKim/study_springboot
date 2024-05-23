package com.khj.restapi05.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member save(Member member){

        Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());

        if(optionalMember.isPresent()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        return memberRepository.save(member);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("qqqqq");
        return null;
    }

    public List<Member> gettAllMembers() {
        return memberRepository.findAll();
    }
}
