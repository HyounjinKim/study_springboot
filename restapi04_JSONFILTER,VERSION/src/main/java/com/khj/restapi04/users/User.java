package com.khj.restapi04.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Schema(description = "User Table에 대한 내용입니다.")
public class User {

    // SEQUENCE 시퀀스 테이블을 생성해서 기본키 관리
    // IDENTITY auto_incretement로 관리
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "사용자 ID",description = "table에서 자동으로 생성되는 컬럼입니다.")
    private Long id;

    @Column(length = 50)
    @Schema(title = "사용자 username",description = "사용자 이름을 넣어주시면 됩니다.")
    private String username;

    @Column(length = 50,unique = true)
    @Schema(title = "사용자 email",description = "사용자 이메일을 넣어주시면 됩니다.")
    private String email;

    @JsonIgnore // 프론트 쪽으로 정보 보낼때 안보냄
    private String password;

    private String grade;

    //@Enumerated(EnumType.ORDINAL) => 0,1 이 들어감
    // @Enumerated(EnumType.STRING) => 문자열이 들어감
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;
}
