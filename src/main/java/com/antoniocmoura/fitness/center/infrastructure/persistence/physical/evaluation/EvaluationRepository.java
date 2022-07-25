package com.antoniocmoura.fitness.center.infrastructure.persistence.physical.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationJpaEntity, Long> {
}
