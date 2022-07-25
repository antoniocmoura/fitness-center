package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.delete;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.EvaluationGateway;

public class DeleteEvaluationUseCase implements DeleteEvaluationUseCaseContract {

    private final EvaluationGateway evaluationGateway;

    public DeleteEvaluationUseCase(final EvaluationGateway evaluationGateway) {
        this.evaluationGateway = evaluationGateway;
    }

    @Override
    public void execute(Long id) {
       this.evaluationGateway.deleteById(id);
    }
}
