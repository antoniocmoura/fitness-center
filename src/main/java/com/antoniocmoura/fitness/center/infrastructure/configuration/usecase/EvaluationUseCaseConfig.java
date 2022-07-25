package com.antoniocmoura.fitness.center.infrastructure.configuration.usecase;

import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create.CreateEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create.CreateEvaluationUseCase;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.delete.DeleteEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.delete.DeleteEvaluationUseCase;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall.FindAllEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall.FindAllEvaluationUseCase;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.get.FindByIdEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.get.FindByIdEvaluationUseCase;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update.UpdateEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update.UpdateEvaluationUseCase;
import com.antoniocmoura.fitness.center.domain.entity.physical.evaluation.EvaluationGateway;
import com.antoniocmoura.fitness.center.domain.entity.student.StudentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvaluationUseCaseConfig {

    private final StudentGateway studentGateway;
    private final EvaluationGateway evaluationGateway;

    public EvaluationUseCaseConfig(
            final StudentGateway studentGateway,
            final EvaluationGateway evaluationGateway
    ) {
        this.studentGateway = studentGateway;
        this.evaluationGateway = evaluationGateway;
    }

    @Bean
    public CreateEvaluationUseCaseContract createEvaluationUseCase() {
        return new CreateEvaluationUseCase(studentGateway, evaluationGateway);
    }

    @Bean
    public FindAllEvaluationUseCaseContract findAllEvaluationUseCase() {
        return new FindAllEvaluationUseCase(evaluationGateway);
    }

    @Bean
    public FindByIdEvaluationUseCaseContract findByIdEvaluationUseCase() {
        return new FindByIdEvaluationUseCase(evaluationGateway);
    }

    @Bean
    public UpdateEvaluationUseCaseContract updateEvaluationUseCase() {
        return new UpdateEvaluationUseCase(studentGateway, evaluationGateway);
    }

    @Bean
    public DeleteEvaluationUseCaseContract deleteEvaluationUseCase() {
        return new DeleteEvaluationUseCase(evaluationGateway);
    }

}
