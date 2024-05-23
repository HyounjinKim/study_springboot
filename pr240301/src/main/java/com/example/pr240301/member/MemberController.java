package com.example.pr240301.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("aa")
    public String aa(Model model) {
        String str = "hihi";
        model.addAttribute("hi", str);

        return "aa";
    }

    @PostMapping("aa")
    public String look(Member member){
        System.out.println(member);
        memberService.save(member);
        return "index";
    }
}
