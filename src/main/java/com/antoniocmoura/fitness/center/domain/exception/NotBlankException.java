package com.antoniocmoura.fitness.center.domain.exception;

public class NotBlankException extends DomainException {

    public NotBlankException() {
        super();
    }

    public NotBlankException(String field) {
        super(String.format("'%s' should not be empty", field));
    }
}