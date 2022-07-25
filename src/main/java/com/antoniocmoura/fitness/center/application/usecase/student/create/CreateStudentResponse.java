package com.antoniocmoura.fitness.center.application.usecase.student.create;

import com.antoniocmoura.fitness.center.domain.entity.student.Student;

import java.time.Instant;
import java.time.LocalDate;

public record CreateStudentResponse(
        Long id,
        String name,
        String cpf,
        String address,
        LocalDate birthDate,
        Instant createdAt
) {
   public static CreateStudentResponse fromDomain(
           final Student aStudent
   ) {
       return new CreateStudentResponse(
               aStudent.getId(),
               aStudent.getName(),
               aStudent.getCpf(),
               aStudent.getAddress(),
               aStudent.getBirthDate(),
               aStudent.getCreatedAt()
       );
   }
}
