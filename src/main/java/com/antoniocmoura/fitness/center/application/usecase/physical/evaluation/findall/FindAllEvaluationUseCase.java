package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.EvaluationGateway;

import java.util.List;

public class FindAllEvaluationUseCase implements FindAllEvaluationUseCaseContract {

    private final EvaluationGateway evaluationGateway;

    public FindAllEvaluationUseCase(final EvaluationGateway evaluationGateway) {
        this.evaluationGateway = evaluationGateway;
    }

    @Override
    public List<FindAllEvaluationResponse> execute() {
        return evaluationGateway.findAll()
                .stream()
                .map(FindAllEvaluationResponse::fromDomain)
                .toList();
    }
}
