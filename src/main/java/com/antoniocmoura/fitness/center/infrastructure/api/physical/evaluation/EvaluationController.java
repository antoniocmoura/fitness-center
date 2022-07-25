package com.antoniocmoura.fitness.center.infrastructure.api.physical.evaluation;

import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create.CreateEvaluationRequest;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create.CreateEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.delete.DeleteEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall.FindAllEvaluationResponse;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall.FindAllEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.get.FindByIdEvaluationResponse;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.get.FindByIdEvaluationUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update.UpdateEvaluationRequest;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update.UpdateEvaluationUseCaseContract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class EvaluationController implements EvaluationEndpoint {

    private final CreateEvaluationUseCaseContract createEvaluationUseCase;
    private final FindAllEvaluationUseCaseContract findAllEvaluationUseCase ;
    private final FindByIdEvaluationUseCaseContract findByIdEvaluationUseCase;
    private final UpdateEvaluationUseCaseContract updateEvaluationUseCase;
    private final DeleteEvaluationUseCaseContract deleteEvaluationUseCase;

    public EvaluationController(
            final CreateEvaluationUseCaseContract createEvaluationUseCase,
            final FindAllEvaluationUseCaseContract findAllEvaluationUseCase,
            final FindByIdEvaluationUseCaseContract findByIdEvaluationUseCase,
            final UpdateEvaluationUseCaseContract updateEvaluationUseCase,
            final DeleteEvaluationUseCaseContract deleteEvaluationUseCase
    ) {
        this.createEvaluationUseCase = createEvaluationUseCase;
        this.findAllEvaluationUseCase = findAllEvaluationUseCase;
        this.findByIdEvaluationUseCase = findByIdEvaluationUseCase;
        this.updateEvaluationUseCase = updateEvaluationUseCase;
        this.deleteEvaluationUseCase = deleteEvaluationUseCase;
    }

    @Override
    public ResponseEntity<?> create(CreateEvaluationRequest request) {
        final var response = createEvaluationUseCase.execute(request);
        return ResponseEntity.created(URI.create("/physical-evaluation/" + response.id())).body(response);
    }

    @Override
    public List<FindAllEvaluationResponse> getAll() {
        return this.findAllEvaluationUseCase.execute();
    }

    @Override
    public FindByIdEvaluationResponse getById(Long id) {
        return this.findByIdEvaluationUseCase.execute(id);
    }

    @Override
    public ResponseEntity<?> updateById(Long id, UpdateEvaluationRequest request) {
        final var response = this.updateEvaluationUseCase.execute(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public void deleteById(Long id) {
        this.deleteEvaluationUseCase.execute(id);
    }
}
