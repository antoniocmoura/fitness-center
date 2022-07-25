package com.antoniocmoura.fitness.center.application.usecase.student.update;

import com.antoniocmoura.fitness.center.application.exception.ValidationException;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;

public class UpdateStudentUseCase implements UpdateStudentUseCaseContract {

    private final StudentGateway studentGateway;

    public UpdateStudentUseCase(final StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public UpdateStudentResponse execute(Long id, UpdateStudentRequest request) {
        final var student = studentGateway.findById(id);
        if (student.isEmpty()) {
            throw new ValidationException("'student' with ID %s not exists", id);
        }
        final var updatedStudent = request.toDomain(student.get());
        updatedStudent.validate();
        final var response = studentGateway.update(updatedStudent);
        return UpdateStudentResponse.fromDomain(response);
    }

    @Override
    public UpdateStudentResponse execute(Long id, Boolean active) {
        final var student = studentGateway.findById(id);
        if (student.isEmpty()) {
            throw new ValidationException("'student' with ID %s not exists", id);
        }
        student.get().updateActive(active);
        final var response = studentGateway.update(student.get());
        return UpdateStudentResponse.fromDomain(response);
    }
}
