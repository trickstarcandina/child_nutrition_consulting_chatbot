package com.example.chatbotspring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> apiException()
    {
        return ResponseEntity.badRequest().body("Không thể nhận dạng thông tin cần tư vấn");
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> exception()
    {
        return ResponseEntity.badRequest().body("Không thể nhận dạng thông tin cần tư vấn");
    }

}
