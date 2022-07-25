package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;

import java.time.LocalDateTime;

public record FindAllEvaluationResponse(
        Long id,
        Long studentId,
        LocalDateTime evaluationDate,
        Double weight,
        Double height
) {
    public static FindAllEvaluationResponse fromDomain(
            final Evaluation evaluation
    ) {
        return new FindAllEvaluationResponse(
                evaluation.getId(),
                evaluation.getStudentId(),
                evaluation.getEvaluationDate(),
                evaluation.getWeight(),
                evaluation.getHeight()
        );
    }
}
