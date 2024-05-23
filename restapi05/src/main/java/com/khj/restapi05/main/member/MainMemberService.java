package com.khj.restapi05.main.member;

import com.khj.restapi05.member.Member;
import com.khj.restapi05.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainMemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        System.out.println(optionalMember);
        if (optionalMember.isEmpty()) {
            System.out.println("해당하는 사용자가 없습니다.");
        }

        Member member = optionalMember.get();

        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
