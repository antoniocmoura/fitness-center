package com.antoniocmoura.fitness.center.application.usecase.student.create;

import com.antoniocmoura.fitness.center.domain.entity.student.Student;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

public record CreateStudentRequest(
        String name,
        String cpf,
        String address,
        LocalDate birthDate
) {
    public Student toDomain() {
        final var now = Instant.now();
        return Student.newStudent(
                0l,
                name,
                cpf,
                address,
                birthDate,
                true,
                now,
                null,
                new ArrayList<>()
        );
    }
}
