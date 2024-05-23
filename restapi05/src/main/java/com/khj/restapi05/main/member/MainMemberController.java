package com.khj.restapi05.main.member;


import com.khj.restapi05.member.Member;
import com.khj.restapi05.member.MemberDto;
import com.khj.restapi05.member.MemberRepository;
import com.khj.restapi05.member.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("main")
@RequiredArgsConstructor
public class MainMemberController {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("member")
    public String member(Model model) {

        List<Member> memberList = memberRepository.findAll();

        model.addAttribute("list", memberList);
        List<String> list = Arrays.asList("111", "222", "333");
        model.addAttribute("stringlist", list);
        return "member/member";
    }

    @GetMapping("join")
    public String join(Model model) {

        return "member/join";
    }

    @PostMapping("join")
    public String pjoin(MemberDto memberDto) {

        memberRepository.save(
                Member.builder()
                        .email(memberDto.getEmail())
                        .username(memberDto.getUsername())
                        .password(passwordEncoder.encode(memberDto.getPassword()))
                        .role(Role.USER)
                        .build()
        );

        return "redirect:/main/member";
    }

    @GetMapping("login")
    public String login(){
        return "member/login";
    }
}
