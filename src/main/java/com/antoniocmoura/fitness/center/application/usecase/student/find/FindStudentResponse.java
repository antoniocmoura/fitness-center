package com.antoniocmoura.fitness.center.application.usecase.student.find;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;
import com.antoniocmoura.fitness.center.domain.entity.student.Student;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record FindStudentResponse(
        Long id,
        String name,
        String cpf,
        String address,
        LocalDate birthDate,
        Boolean active,
        Instant createdAt,
        Instant updatedAt,
        List<StudentEvaluations> evaluations
) {
    public static FindStudentResponse fromDomain(
            final Student aStudent
    ) {
        return new FindStudentResponse(
                aStudent.getId(),
                aStudent.getName(),
                aStudent.getCpf(),
                aStudent.getAddress(),
                aStudent.getBirthDate(),
                aStudent.getActive(),
                aStudent.getCreatedAt(),
                aStudent.getUpdatedAt(),
                aStudent.getEvaluations().stream()
                        .map(StudentEvaluations::fromDomain)
                        .collect(Collectors.toList())
        );
    }

    public record StudentEvaluations(
            Long id,
            LocalDateTime evaluationDate,
            Double weight,
            Double height
    ) {
        public static StudentEvaluations fromDomain(
                final Evaluation evaluation
        ) {
             return new StudentEvaluations(
                     evaluation.getId(),
                     evaluation.getEvaluationDate(),
                     evaluation.getWeight(),
                     evaluation.getHeight()
             );
        }
    }
}
