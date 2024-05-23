package com.khj.portfolio.kakaomap;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("market")
@RequiredArgsConstructor
public class MarketController {

    private final MarketRepository marketRepository;

    @GetMapping("address")
    public ResponseEntity<List<Market>> marketAddress(){
        List<Market> market = marketRepository.findAll();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(market);
    }
}
