package com.khj.restapi04.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    DUPLICATE(HttpStatus.BAD_REQUEST,"DUPLICATE","중복된 내용이 있습니다."),
    NOTFOUND(HttpStatus.NOT_FOUND,"NOTFOUND","내용이 없습니다."),
    TEST(HttpStatus.BAD_GATEWAY,"TEST","TEST입니다."),
    NOTUPDATEEMAIL(HttpStatus.NOT_FOUND,"NOTUPDATEEMAIL","수정할 이메일이 없습니다."),
    LOGINFAILED(HttpStatus.UNAUTHORIZED,"LOGINFAIL","이메일패스워드확인하세요");

    ;


    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
