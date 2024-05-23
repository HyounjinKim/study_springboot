package com.khj.mychart.person;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDto {
    private String name;
    private int age;
}
