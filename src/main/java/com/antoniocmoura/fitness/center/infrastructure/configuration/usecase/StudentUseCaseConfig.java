package com.antoniocmoura.fitness.center.infrastructure.configuration.usecase;

import com.antoniocmoura.fitness.center.application.usecase.student.create.CreateStudentUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.student.create.CreateStudentUseCase;
import com.antoniocmoura.fitness.center.application.usecase.student.find.findall.FindAllStudentUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.student.find.findall.FindAllStudentUseCase;
import com.antoniocmoura.fitness.center.application.usecase.student.find.get.FindByIdStudentUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.student.find.get.FindByIdStudentUseCase;
import com.antoniocmoura.fitness.center.application.usecase.student.update.UpdateStudentUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.student.update.UpdateStudentUseCase;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentUseCaseConfig {

    private final StudentGateway studentGateway;

    public StudentUseCaseConfig(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Bean
    public CreateStudentUseCaseContract createStudentUseCase() {
        return new CreateStudentUseCase(studentGateway);
    }

    @Bean
    public FindAllStudentUseCaseContract findAllStudentUseCase() {
        return new FindAllStudentUseCase(studentGateway);
    }

    @Bean
    public FindByIdStudentUseCaseContract findByIdStudentUseCase() {
        return new FindByIdStudentUseCase(studentGateway);
    }

    @Bean
    public UpdateStudentUseCaseContract updateStudentUseCase() {
        return new UpdateStudentUseCase(studentGateway);
    }

}
