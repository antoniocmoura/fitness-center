package com.antoniocmoura.fitness.center.application.usecase.student.create;

import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;

public class CreateStudentUseCase implements CreateStudentUseCaseContract {

    private final StudentGateway studentGateway;

    public CreateStudentUseCase(final StudentGateway repository) {
        this.studentGateway = repository;
    }

    @Override
    public CreateStudentResponse execute(CreateStudentRequest request) {
        final var student = request.toDomain();
        student.validate();
        final var response = studentGateway.create(student);
        return CreateStudentResponse.fromDomain(response);
    }

}
