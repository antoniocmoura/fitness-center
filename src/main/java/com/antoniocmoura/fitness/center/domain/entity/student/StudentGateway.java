package com.antoniocmoura.fitness.center.domain.entity.student;

import java.util.List;
import java.util.Optional;

public interface StudentGateway {

    Student create(final Student aStudent);

    List<Student> findAll();

    Optional<Student> findById(final Long id);

    Student update(final Student student);

}
