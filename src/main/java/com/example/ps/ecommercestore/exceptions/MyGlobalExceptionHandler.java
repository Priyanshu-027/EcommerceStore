package com.example.ps.ecommercestore.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class MyGlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e){

        Map<String,String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err->{
            String FieldName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            response.put(FieldName,message);
        });
        return ResponseEntity.status(400).body(response);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> myResourceNotFoundException(ResourceNotFoundException e){

        String message = e.getMessage();
        return ResponseEntity.status(404).body(message);
    }
    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> myAPIException(APIException e){

        String message = e.getMessage();
        return ResponseEntity.badRequest().body(message);
    }
}
