package com.antoniocmoura.fitness.center.infrastructure.configuration.exception;

import javax.validation.ConstraintViolation;

public record FieldError(
        String field,
        String message
) {
    public static FieldError from(ConstraintViolation constraintViolation) {
        return new FieldError(
                constraintViolation.getPropertyPath().toString(),
                constraintViolation.getMessage()
        );
    }
}
