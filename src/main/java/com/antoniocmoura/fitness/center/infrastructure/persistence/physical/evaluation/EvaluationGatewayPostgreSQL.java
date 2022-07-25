package com.antoniocmoura.fitness.center.infrastructure.persistence.physical.evaluation;

import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.Evaluation;
import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.EvaluationGateway;
import com.antoniocmoura.fitness.center.domain.entity.student.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationGatewayPostgreSQL implements EvaluationGateway {

    private final EvaluationRepository repository;

    public EvaluationGatewayPostgreSQL(final EvaluationRepository evaluationRepository) {
        this.repository = evaluationRepository;
    }

    @Override
    public Evaluation create(final Student student, final Evaluation evaluation) {
        final var entity = EvaluationJpaEntity.fromDomain(student, evaluation);
        return repository.save(entity).toDomain();
    }

    @Override
    public List<Evaluation> findAll() {
        return repository.findAll()
                .stream()
                .map(EvaluationJpaEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Evaluation> findById(final Long id) {
        return repository.findById(id).map(EvaluationJpaEntity::toDomain);
    }

    @Override
    public Evaluation update(final Student student, final Evaluation evaluation) {
        final var entity = EvaluationJpaEntity.fromDomain(student, evaluation);
        return repository.save(entity).toDomain();
    }

    @Override
    public void deleteById(final Long id) {
       if (this.repository.existsById(id)) {
           this.repository.deleteById(id);
       }
    }
}
