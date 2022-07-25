package com.antoniocmoura.fitness.center.application.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
    public ValidationException(String message, Object ... params) {
        super(String.format(message, params));
    }
}
