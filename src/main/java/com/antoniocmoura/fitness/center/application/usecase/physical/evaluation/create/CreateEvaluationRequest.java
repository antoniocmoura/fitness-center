package com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;

import java.time.LocalDateTime;

public record CreateEvaluationRequest(
        Long studentId,
        Double weight,
        Double height
) {
    public Evaluation toDomain() {
        final var now = LocalDateTime.now();
        return Evaluation.newPhysicalEvaluation(
                0l,
                studentId,
                now,
                this.weight,
                this.height
        );
    }
}
