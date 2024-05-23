package com.firstproject.project.project.friend;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "친구목록Dto",description = "친구목록 DB 유효성 검사 클래스")
public class FriendDto {

    @Schema(title = "기본키")
    private Long id;
    @Schema(title = "본인 닉네임")
    private String membernick;
    @Schema(title = "친구 닉네임")
    private String friendnick;
    @Schema(title = "친구신청 진행 상황")
    private Approve approve;
}
