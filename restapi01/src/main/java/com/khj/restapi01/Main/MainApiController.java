package com.khj.restapi01.Main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainApiController {

    @GetMapping("main/api/aa")
    public String mainApiaa(String str,String id,String age) {
        System.out.println("id = " + id);
        System.out.println("age = " + age);
        return String.format("문자열 보내짐. 이름 = %s 아이디 = %s 나이 = %s",str,id,age);
    }
}
