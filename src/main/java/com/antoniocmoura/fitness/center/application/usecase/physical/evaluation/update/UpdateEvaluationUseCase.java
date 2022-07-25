package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update;

import com.antoniocmoura.fitness.center.application.exception.ValidationException;
import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.EvaluationGateway;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;

public class UpdateEvaluationUseCase implements UpdateEvaluationUseCaseContract {

    private final StudentGateway studentGateway;
    private final EvaluationGateway evaluationGateway;

    public UpdateEvaluationUseCase(
            final StudentGateway studentGateway,
            final EvaluationGateway evaluationGateway) {
        this.studentGateway = studentGateway;
        this.evaluationGateway = evaluationGateway;
    }

    @Override
    public UpdateEvaluationResponse execute(Long id, UpdateEvaluationRequest request) {
        final var physicalEvaluation = evaluationGateway.findById(id);
        if (physicalEvaluation.isEmpty()) {
            throw new ValidationException("'evaluation' with ID %s not exists", id);
        }
        final var student = studentGateway.findById(request.studentId());
        if (student.isEmpty()) {
            throw new ValidationException("'student' with ID %s not exists", request.studentId());
        }
        physicalEvaluation.get().validate();
        final var response = evaluationGateway.update(student.get(), request.toDomain(id));
        return UpdateEvaluationResponse.fromDomain(response);
    }
}
