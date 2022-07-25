package com.antoniocmoura.fitness.center.domain.entity.physical.evaluation;

import com.antoniocmoura.fitness.center.domain.entity.student.Student;

import java.util.List;
import java.util.Optional;

public interface EvaluationGateway {

    Evaluation create(final Student student, final Evaluation evaluation);

    List<Evaluation> findAll();

    Optional<Evaluation> findById(final Long id);

    Evaluation update(final Student student, final Evaluation evaluation);

    void deleteById(final Long id);

}
