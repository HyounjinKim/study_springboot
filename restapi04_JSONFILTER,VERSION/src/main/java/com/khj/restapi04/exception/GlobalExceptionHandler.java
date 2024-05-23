package com.khj.restapi04.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LogicException.class)
    public final ResponseEntity<ErrorResponse> handleLogException(LogicException ex){
        ErrorResponse errorResponse = ErrorResponse.builder()

                .errorCode(ex.getErrorCode().getErrorCode())
                .errorMessage(ex.getErrorCode().getMessage())
                .errorDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(errorResponse);
    }

    @ExceptionHandler(UsersException.class)
    public final ResponseEntity<ErrorResponse> handleException(UsersException e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(e.getErrorCode().getMessage())
                .errorCode(e.getErrorCode().getErrorCode())
                .errorDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

//    @ExceptionHandler(BindException.class)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        System.out.println("유효성 실패" + ex.getMessage());
        System.out.println("유효성 실패" + ex.getBindingResult());

        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .errorCode(HttpStatus.BAD_REQUEST.toString())
//                .errorMessage(ex.getBindingResult().toString())
                .errorMessage(ex.getBindingResult().getFieldError().getDefaultMessage())
                .errorDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
