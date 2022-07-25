package com.antoniocmoura.fitness.center.domain.entity.physical.evaluation;

import com.antoniocmoura.fitness.center.domain.exception.DomainException;
import com.antoniocmoura.fitness.center.domain.exception.NotNullException;

public class EvaluationValidation {
    public static void validate(Evaluation evaluation) {
        if (evaluation.getHeight() == null) {
            throw new NotNullException("height");
        }
        if (evaluation.getHeight() == 0) {
            throw new DomainException("'height' must be greater than zero");
        }
        if (evaluation.getWeight() == null) {
            throw new NotNullException("weight");
        }
        if (evaluation.getWeight() == 0) {
            throw new DomainException("'weight' must be greater than zero");
        }
    }
}
