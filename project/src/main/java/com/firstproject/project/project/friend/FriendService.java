package com.firstproject.project.project.friend;

import com.firstproject.project.project.exception.ErrorCode;
import com.firstproject.project.project.exception.LoginException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;

    public List<String> friendList(FriendDto friendDto) {
        List<String> list = friendRepository.findFriendList(friendDto.getMembernick());

        return list;
    }

    public List<String> beRequestList(FriendDto friendDto) {
        List<String> list = friendRepository.findBerequestList(friendDto.getFriendnick());

        return list;
    }

    public String accept(String membernick, String friendnick) {
        Friend friend = friendRepository.acceptFriend(membernick, friendnick);

        if (friend != null) {
            friend.setApprove(Approve.Y);

            friendRepository.save(friend);

            Friend acceptFriend = Friend.builder()
                    .membernick(membernick)
                    .friendnick(friendnick)
                    .approve(Approve.Y)
                    .build();

            friendRepository.save(acceptFriend);

            return "친구추가";
        }

        return "친구추가 실패";
    }

    public String refuse(String membernick, String friendnick) {
        Friend friend = friendRepository.acceptFriend(membernick, friendnick);

        System.out.println(friend);
        if (friend != null) {
            friendRepository.delete(friend);
        }
        return "친구거절";
    }

    public String search(String friendnick,String membernick) {
        String friend = friendRepository.findFriend(friendnick);
        if (friend == null) {
            throw new LoginException(ErrorCode.USERNOTFOUND);
        }
        if(friend.equals(membernick)){
            throw new LoginException(ErrorCode.YOURNICKNAME);
        }

        return friend;
    }

    public String request(FriendDto friendDto) {
        String result = friendRepository.findFriend(friendDto.getFriendnick());

        if (result != null) {
            Friend friend = Friend.builder()
                    .membernick(friendDto.getMembernick())
                    .friendnick(friendDto.getFriendnick())
                    .build();

            friendRepository.save(friend);
            return "요청 완료";
        }
        return "요청 실패";
    }

    public String delete(String membernick, String friendnick) {
        Friend member = friendRepository.findDeleteFriend(membernick,friendnick);
        Friend friend = friendRepository.acceptFriend(membernick,friendnick);

        if(member != null && friend != null){
            friendRepository.delete(member);
            friendRepository.delete(friend);

            return "삭제 완료";
        }

        return "삭제 실패";
    }
}
