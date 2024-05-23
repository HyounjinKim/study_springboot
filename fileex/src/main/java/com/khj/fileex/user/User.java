package com.khj.fileex.user;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name",nullable = false, length = 50)
    private String name;
    @Column(name = "email",nullable = false, length = 50,unique = true)
    private String email;
    private String password;
    private String role;
    private String imagePath;
}
