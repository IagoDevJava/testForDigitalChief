package com.egorov.exception;

public class FacultyNotFoundException extends RuntimeException {
    public FacultyNotFoundException(String message) {
        super(message);
    }
}
