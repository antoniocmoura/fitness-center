package com.antoniocmoura.fitness.center.domain.entity.student;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
public class Student {
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private LocalDate birthDate;
    private Boolean active;
    private Instant createdAt;
    private Instant updatedAt;

    private List<Evaluation> evaluations;

    protected Student(
            final Long id,
            final String name,
            final String cpf,
            final String address,
            final LocalDate birthDate,
            final Boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final List<Evaluation> evaluations
    ) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.birthDate = birthDate;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.evaluations = evaluations;
    }

    public static Student newStudent(
            final Long id,
            final String name,
            final String cpf,
            final String address,
            final LocalDate birthDate,
            final Boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final List<Evaluation> evaluations

    ){
        return new Student(
                id,
                name,
                cpf,
                address,
                birthDate,
                active,
                createdAt,
                updatedAt,
                evaluations
        );
    }

    public Student updateActive(final boolean active) {
        this.active = active;
        this.updatedAt = Instant.now();
        return this;
    }

    public void validate() {
        StudentValidation.validate(this);
    }
}
