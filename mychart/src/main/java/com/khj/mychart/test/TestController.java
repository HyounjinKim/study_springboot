package com.khj.mychart.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("test")
public class TestController {
    private final TestClient testClient;

    @GetMapping("test")
    public ResponseEntity<String> test() {
        String test = testClient.getTest();
        System.out.println(test);
        return ResponseEntity.status(HttpStatus.OK).body(test);
    }

}
