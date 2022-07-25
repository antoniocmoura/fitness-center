package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;

import java.time.LocalDateTime;

public record CreateEvaluationResponse(
        Long id,
        Long studentId,
        LocalDateTime evaluationDate,
        Double weight,
        Double height
) {
    public static CreateEvaluationResponse fromDomain(
            final Evaluation evaluation
            ) {
        return new CreateEvaluationResponse(
                evaluation.getId(),
                evaluation.getStudentId(),
                evaluation.getEvaluationDate(),
                evaluation.getWeight(),
                evaluation.getHeight()
        );
    }
}
