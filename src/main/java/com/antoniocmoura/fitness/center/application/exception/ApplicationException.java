package com.antoniocmoura.fitness.center.application.exception;

public class ApplicationException extends RuntimeException {
    public ApplicationException(String message) {
        super(message);
    }
    public ApplicationException(String message, Object ... params) {
        super(String.format(message, params));
    }
}
