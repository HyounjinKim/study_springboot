package com.example.pr240301.conf;

import com.example.pr240301.member.MemberRepository;
import com.example.pr240301.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.examlple.pr240301.member"})
public class Myconf {

}
