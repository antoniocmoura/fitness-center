package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;

import java.time.LocalDateTime;

public record UpdateEvaluationResponse(
        Long id,
        Long studentId,
        LocalDateTime evaluationDate,
        Double weight,
        Double height
) {
    public static UpdateEvaluationResponse fromDomain(
            final Evaluation evaluation
    ) {
        return new UpdateEvaluationResponse(
                evaluation.getId(),
                evaluation.getStudentId(),
                evaluation.getEvaluationDate(),
                evaluation.getWeight(),
                evaluation.getHeight()
        );
    }
}
