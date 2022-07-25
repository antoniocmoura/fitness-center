package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall;

import java.util.List;

public interface FindAllEvaluationUseCaseContract {
    List<FindAllEvaluationResponse> execute();
}
