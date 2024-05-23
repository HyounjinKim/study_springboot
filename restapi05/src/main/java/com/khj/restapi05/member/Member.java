package com.khj.restapi05.member;

import com.khj.restapi05.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String username;
    private String password;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
