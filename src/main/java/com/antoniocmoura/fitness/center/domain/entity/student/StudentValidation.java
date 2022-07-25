package com.antoniocmoura.fitness.center.domain.entity.student;

import com.antoniocmoura.fitness.center.domain.exception.DomainException;
import com.antoniocmoura.fitness.center.domain.exception.NotBlankException;
import com.antoniocmoura.fitness.center.domain.exception.NotNullException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class StudentValidation {
    private static final int MINIMUM_AGE = 16;

    public static void validate(Student student) {
        if (student.getName() == null) {
            throw new NotNullException("name");
        }
        if (student.getName().isEmpty()) {
            throw new NotBlankException("name");
        }
        if (student.getCpf() == null) {
            throw new NotNullException("cpf");
        }
        if (student.getCpf().isEmpty()) {
            throw new NotBlankException("cpf");
        }
        if (student.getAddress() == null) {
            throw new NotNullException("address");
        }
        if (student.getAddress().isEmpty()) {
            throw new NotBlankException("address");
        }
        if (student.getBirthDate() == null) {
            throw new NotNullException("birthDate");
        }
        final var now =  LocalDateTime.now();
        if (ChronoUnit.YEARS.between(student.getBirthDate(), now) < MINIMUM_AGE) {
            throw new DomainException("student must be over 16 years old");
        }
    }
}
