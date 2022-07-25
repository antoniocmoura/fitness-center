package com.antoniocmoura.fitness.center.infrastructure.configuration.exception;

import java.util.Date;
import java.util.List;

public record ValidationError(
        Date timestamp,
        String status,
        int statusCode,
        List<FieldError> errors
) {
    public static ValidationError newError(
            final List<FieldError> errors
    ) {
        final var now = new Date();
        return new ValidationError(
                now,
                "validation error",
                422,
                errors
        );
    }
}
