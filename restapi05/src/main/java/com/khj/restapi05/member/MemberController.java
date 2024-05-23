package com.khj.restapi05.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public String member(Authentication authentication){
        Member member = (Member) authentication.getPrincipal();

        return "getMember email = " + member.getEmail() + " username = " + member.getUsername() + " role = " + member.getRole();
    }

    //Vaild 유효성검사
    @PostMapping("join")
    public ResponseEntity<String> member(@Valid @RequestBody MemberDto memberDto){
        ModelMapper modelMapper = new ModelMapper();

        Member member = modelMapper.map(memberDto,Member.class);

        memberService.save(member);
        return ResponseEntity.status(HttpStatus.OK).body("성공");
    }

    @GetMapping("list")
    public ResponseEntity<List<Member>> member(){
        List<Member> allMembers = memberService.gettAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(allMembers);
    }
}
