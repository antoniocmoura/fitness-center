package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update;

public interface UpdateEvaluationUseCaseContract {
    UpdateEvaluationResponse execute(Long id, UpdateEvaluationRequest request);
}
