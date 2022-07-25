package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;

import java.time.LocalDateTime;

public record UpdateEvaluationRequest(
        Long studentId,
        Double weight,
        Double height
) {
    public Evaluation toDomain(Long id) {
        final var now = LocalDateTime.now();
        return Evaluation.newPhysicalEvaluation(
                id,
                studentId,
                now,
                this.weight,
                this.height
        );
    }
}
