package com.antoniocmoura.fitness.center.application.usecase.student.find.findall;

import com.antoniocmoura.fitness.center.application.usecase.student.find.FindStudentResponse;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;

import java.util.List;

public class FindAllStudentUseCase implements FindAllStudentUseCaseContract {

    private final StudentGateway studentGateway;

    public FindAllStudentUseCase(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public List<FindStudentResponse> execute() {
        return studentGateway.findAll()
                .stream()
                .map(FindStudentResponse::fromDomain)
                .toList();
    }

}
