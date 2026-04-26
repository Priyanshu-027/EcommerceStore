package com.example.ps.ecommercestore.exceptions;

public class APIException extends RuntimeException{

    private static final Long serialVersionUid = 1L;

    public APIException() {
    }

    public APIException(String message) {
        super(message);
    }
}
