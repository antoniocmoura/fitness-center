package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.get;

import com.antoniocmoura.fitness.center.application.exception.ValidationException;
import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.EvaluationGateway;

public class FindByIdEvaluationUseCase implements FindByIdEvaluationUseCaseContract {

    private final EvaluationGateway evaluationGateway;

    public FindByIdEvaluationUseCase(final EvaluationGateway evaluationGateway) {
        this.evaluationGateway = evaluationGateway;
    }

    @Override
    public FindByIdEvaluationResponse execute(Long id) {
        return evaluationGateway.findById(id)
                .map(FindByIdEvaluationResponse::fromDomain)
                .orElseThrow(() -> new ValidationException("'evaluation' with ID %s not exists", id));
    }
}
