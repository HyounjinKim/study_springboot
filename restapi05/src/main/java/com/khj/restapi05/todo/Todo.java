package com.khj.restapi05.todo;


import com.khj.restapi05.member.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    private String todo;

    @ManyToOne
    private Member member;
}
