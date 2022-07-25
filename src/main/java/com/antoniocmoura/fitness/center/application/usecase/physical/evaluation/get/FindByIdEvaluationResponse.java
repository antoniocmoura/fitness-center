package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.get;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;

import java.time.LocalDateTime;

public record FindByIdEvaluationResponse(
        Long id,
        Long studentId,
        LocalDateTime evaluationDate,
        Double weight,
        Double height
) {
    public static FindByIdEvaluationResponse fromDomain(
        final Evaluation evaluation
    ) {
        return new FindByIdEvaluationResponse(
                evaluation.getId(),
                evaluation.getStudentId(),
                evaluation.getEvaluationDate(),
                evaluation.getWeight(),
                evaluation.getHeight()
        );
    }
}
