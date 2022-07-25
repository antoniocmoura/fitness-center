package com.antoniocmoura.fitness.center.application.usecase.student.find.get;

import com.antoniocmoura.fitness.center.application.exception.ApplicationException;
import com.antoniocmoura.fitness.center.application.usecase.student.find.FindStudentResponse;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;

public class FindByIdStudentUseCase implements FindByIdStudentUseCaseContract {

    private final StudentGateway studentGateway;

    public FindByIdStudentUseCase(final StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public FindStudentResponse execute(Long id) {
        return studentGateway.findById(id)
                .map(FindStudentResponse::fromDomain)
                .orElseThrow(() -> new ApplicationException("Student %s not found", id));
    }
}
