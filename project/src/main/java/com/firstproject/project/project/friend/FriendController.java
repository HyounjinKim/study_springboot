package com.firstproject.project.project.friend;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
@Tag(name = "FriendController",description = "친구 목록조회,검색,요청,수락,거절,삭제 기능")
public class FriendController {

    private final FriendService friendService;

    @Operation(summary = "친구검색")
    @PostMapping("search")
    public ResponseEntity<String> postFriendSearch(@RequestBody FriendDto friendDto){
        String result = friendService.search(friendDto.getFriendnick(),friendDto.getMembernick());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "친구목록 조회")
    @PostMapping("list")
    public ResponseEntity<List<String>> postFriendList(@RequestBody FriendDto friendDto){
        List<String> list = friendService.friendList(friendDto);

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(summary = "친구요청")
    @PostMapping("request")
    public ResponseEntity<String> postRequest(@RequestBody FriendDto friendDto){
        String result = friendService.request(friendDto);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "친구요청 확인")
    @PostMapping("berequest")
    public ResponseEntity<List<String>> postBeRequestList(@RequestBody FriendDto friendDto){
        List<String> list = friendService.beRequestList(friendDto);

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(summary = "친구수락")
    @PutMapping("accept")
    public ResponseEntity<String> putAccept(@RequestBody FriendDto friendDto){
        String result = friendService.accept(friendDto.getMembernick(),friendDto.getFriendnick());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "친구거절")
    @DeleteMapping("refuse")
    public ResponseEntity<String> delRefuse(@RequestBody FriendDto friendDto){
        String result = friendService.refuse(friendDto.getMembernick(),friendDto.getFriendnick());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "친구삭제")
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteFriend(@RequestBody FriendDto friendDto){
        String result = friendService.delete(friendDto.getMembernick(),friendDto.getFriendnick());

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}