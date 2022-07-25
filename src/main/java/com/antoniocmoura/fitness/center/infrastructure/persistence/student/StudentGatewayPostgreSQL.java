package com.antoniocmoura.fitness.center.infrastructure.persistence.student;

import com.antoniocmoura.fitness.center.domain.entity.student.Student;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGatewayPostgreSQL implements StudentGateway {

    private final StudentRepository repository;

    public StudentGatewayPostgreSQL(final StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student create(final Student aStudent) {
        final var entity = StudentJpaEntity.fromDomain(aStudent);
        return repository.save(entity).toDomain();
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll()
                .stream()
                .map(StudentJpaEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Student> findById(final Long id) {
        return repository.findById(id).map(StudentJpaEntity::toDomain);
    }

    @Override
    public Student update(Student student) {
        final var entity = StudentJpaEntity.fromDomain(student);
        return repository.save(entity).toDomain();
    }
}
