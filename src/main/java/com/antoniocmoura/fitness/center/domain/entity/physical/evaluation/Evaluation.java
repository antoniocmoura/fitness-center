package com.antoniocmoura.fitness.center.domain.entity.physical.evaluation;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Evaluation {
    private Long id;
    private Long studentId;
    private LocalDateTime evaluationDate;
    private Double weight;
    private Double height;

    private Evaluation(
            final Long id,
            final Long studentId,
            final LocalDateTime evaluationDate,
            final Double weight,
            final Double height
    ) {
        this.id = id;
        this.studentId = studentId;
        this.evaluationDate = evaluationDate;
        this.weight = weight;
        this.height = height;
    }

    public static Evaluation newPhysicalEvaluation(
            final Long id,
            final Long studentId,
            final LocalDateTime evaluationDate,
            final Double weight,
            final Double height
    ) {
        return new Evaluation(
                id,
                studentId,
                evaluationDate,
                weight,
                height
        );
    }

    public void validate() {
        EvaluationValidation.validate(this);
    }

}
