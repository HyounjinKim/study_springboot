package com.khj.restapi05.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 @RestController -> JSON 타입을 프론트에 던져줌
 @Controller -> 주소를 던져줌
 */
@Controller
@RequestMapping("main")
public class MainController {

    @RequestMapping(value = "main",method = {RequestMethod.GET,RequestMethod.POST})
    public String main(Model model) {

        model.addAttribute("name","홍길동");

        return "main/main";
    }
}
