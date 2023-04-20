package com.egorov.exception;

public class UniversityNotFoundException extends RuntimeException {
    public UniversityNotFoundException(String message) {
        super(message);
    }
}
