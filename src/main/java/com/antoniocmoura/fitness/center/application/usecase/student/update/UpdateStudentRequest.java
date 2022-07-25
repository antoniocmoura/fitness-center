package com.antoniocmoura.fitness.center.application.usecase.student.update;

import com.antoniocmoura.fitness.center.domain.entity.student.Student;

import java.time.Instant;
import java.time.LocalDate;

public record UpdateStudentRequest(
        String name,
        String cpf,
        String address,
        LocalDate birthDate,
        Boolean active
) {
    public Student toDomain(Student aStudent) {
        final var now = Instant.now();
        return Student.newStudent(
                aStudent.getId(),
                name,
                cpf,
                address,
                birthDate,
                active,
                aStudent.getCreatedAt(),
                Instant.now(),
                aStudent.getEvaluations()
        );
    }
}
