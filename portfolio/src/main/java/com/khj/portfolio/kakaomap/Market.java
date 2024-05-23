package com.khj.portfolio.kakaomap;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Entity
@Table(name = "market")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marketcode;

    @Column(unique = true)
    private String marketname;

    private String address;

    @Column(nullable = false, length = 20)
    private String phonenumber;

    private Time opentime;

    private Time closetime;
}
