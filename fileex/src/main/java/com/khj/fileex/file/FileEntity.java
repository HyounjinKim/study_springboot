package com.khj.fileex.file;


import jakarta.persistence.*;

@Entity
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    private String name;

}
