package com.antoniocmoura.fitness.center.application.usecase.student.update;

public interface UpdateStudentUseCaseContract {
    UpdateStudentResponse execute(Long id, UpdateStudentRequest request);
    UpdateStudentResponse execute(Long id, Boolean active);
}
