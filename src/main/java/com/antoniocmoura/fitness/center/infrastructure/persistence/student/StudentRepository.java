package com.antoniocmoura.fitness.center.infrastructure.persistence.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentJpaEntity, Long> {
}
