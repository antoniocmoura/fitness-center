package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create;

import com.antoniocmoura.fitness.center.application.exception.ValidationException;
import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.EvaluationGateway;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;

public class CreateEvaluationUseCase implements CreateEvaluationUseCaseContract {

    private final StudentGateway studentGateway;
    private final EvaluationGateway evaluationGateway;

    public CreateEvaluationUseCase(
            final StudentGateway studentGateway,
            final EvaluationGateway evaluationGateway
    ) {
        this.studentGateway = studentGateway;
        this.evaluationGateway = evaluationGateway;
    }

    @Override
    public CreateEvaluationResponse execute(CreateEvaluationRequest request) {
        final var student = studentGateway.findById(request.studentId());
        if (student.isEmpty()) {
            throw new ValidationException("'student_id' with ID %s not exists", request.studentId());
        }
        if (!student.get().getActive()) {
            throw new ValidationException("'student' with ID %s is inactive", request.studentId());
        }
        final var physicalEvaluation = request.toDomain();
        physicalEvaluation.validate();
        final var response = evaluationGateway.create(student.get(), request.toDomain());
        return CreateEvaluationResponse.fromDomain(response);
    }
}
