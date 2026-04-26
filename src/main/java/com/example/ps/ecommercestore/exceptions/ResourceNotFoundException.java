package com.example.ps.ecommercestore.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    String field;
    Long fieldId;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message, Throwable cause, String resourceName, String fieldName, String field) {
        super(String.format("%s not found %s: %s",resourceName,field,fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.field = field;
    }

    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s not found %s: %d",resourceName,field,fieldId));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }
}
