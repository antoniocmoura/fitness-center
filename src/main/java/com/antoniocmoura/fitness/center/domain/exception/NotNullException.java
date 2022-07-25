package com.antoniocmoura.fitness.center.domain.exception;

public class NotNullException extends DomainException {

    public NotNullException() {
        super();
    }

    public NotNullException(String field) {
        super(String.format("'%s' should not be null", field));
    }

}
