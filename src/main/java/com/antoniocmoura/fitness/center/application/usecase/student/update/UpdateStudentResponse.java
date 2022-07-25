package com.antoniocmoura.fitness.center.application.usecase.student.update;

import com.antoniocmoura.fitness.center.domain.entity.student.Student;

import java.time.Instant;
import java.time.LocalDate;

public record UpdateStudentResponse(
        Long id,
        String name,
        String cpf,
        String address,
        LocalDate birthDate,
        Boolean active,
        Instant createdAt,
        Instant updatedAt
) {
    public static UpdateStudentResponse fromDomain(Student student) {
        return new UpdateStudentResponse(
                student.getId(),
                student.getName(),
                student.getCpf(),
                student.getAddress(),
                student.getBirthDate(),
                student.getActive(),
                student.getCreatedAt(),
                student.getUpdatedAt()
        );
    }
}
