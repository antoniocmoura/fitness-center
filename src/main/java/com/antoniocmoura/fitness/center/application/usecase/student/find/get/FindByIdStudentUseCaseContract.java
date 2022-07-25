package com.antoniocmoura.fitness.center.application.usecase.student.find.get;

import com.antoniocmoura.fitness.center.application.usecase.student.find.FindStudentResponse;

public interface FindByIdStudentUseCaseContract {
    FindStudentResponse execute(Long id);
}
