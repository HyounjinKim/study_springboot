package com.firstproject.project.project.friend;


import com.firstproject.project.project.login.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Friend")
@DynamicInsert
@Schema(title = "친구목록 정보",description = "친구 목록에 관한 테이블")
@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "기본키")
    private Long id;

    @Column(nullable = false)
    @Schema(title = "본인 닉네임")
    private String membernick;

    @Column(nullable = false)
    @Schema(title = "친구 닉네임")
    private String friendnick;

    @ColumnDefault("'I'")
    @Enumerated(EnumType.STRING)
    @Schema(title = "친구신청 진행 상황")
    private Approve approve;
}
