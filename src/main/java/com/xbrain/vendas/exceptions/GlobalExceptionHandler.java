package com.xbrain.vendas.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(400).body("Dados inválidos. ");
    }

}
