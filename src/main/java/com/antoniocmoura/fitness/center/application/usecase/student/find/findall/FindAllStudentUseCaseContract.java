package com.antoniocmoura.fitness.center.application.usecase.student.find.findall;

import com.antoniocmoura.fitness.center.application.usecase.student.find.FindStudentResponse;

import java.util.List;

public interface FindAllStudentUseCaseContract {
    List<FindStudentResponse> execute();
}
