package com.khj.restapi04.version;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HeaderController {

    @GetMapping(value = "header",headers = "v1=1")
    public String param1(){
        return "headersV1";
    }

    @GetMapping(value = "header",headers = "v1=2")
    public String param2(){
        return "headersV2";
    }
}
