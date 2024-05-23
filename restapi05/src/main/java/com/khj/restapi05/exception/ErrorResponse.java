package com.khj.restapi05.exception;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private String reason;
}
