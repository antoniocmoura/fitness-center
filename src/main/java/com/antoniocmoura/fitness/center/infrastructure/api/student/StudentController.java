package com.antoniocmoura.fitness.center.infrastructure.api.student;

import com.antoniocmoura.fitness.center.application.usecase.student.create.CreateStudentRequest;
import com.antoniocmoura.fitness.center.application.usecase.student.create.CreateStudentUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.student.find.FindStudentResponse;
import com.antoniocmoura.fitness.center.application.usecase.student.find.findall.FindAllStudentUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.student.find.get.FindByIdStudentUseCaseContract;
import com.antoniocmoura.fitness.center.application.usecase.student.update.UpdateStudentRequest;
import com.antoniocmoura.fitness.center.application.usecase.student.update.UpdateStudentUseCaseContract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController implements StudentEndpoint {

    private final CreateStudentUseCaseContract createStudentUseCase;
    private final FindAllStudentUseCaseContract findAllStudentUseCase;
    private final FindByIdStudentUseCaseContract findByIdStudentUseCase;
    private final UpdateStudentUseCaseContract updateStudentUseCase;

    public StudentController(
            final CreateStudentUseCaseContract createStudentUseCase,
            final FindAllStudentUseCaseContract findAllStudentUseCase,
            final FindByIdStudentUseCaseContract findByIdStudentUseCase,
            final UpdateStudentUseCaseContract updateStudentUseCase) {
        this.createStudentUseCase = createStudentUseCase;
        this.findAllStudentUseCase = findAllStudentUseCase;
        this.findByIdStudentUseCase = findByIdStudentUseCase;
        this.updateStudentUseCase = updateStudentUseCase;
    }

    @Override
    public ResponseEntity<?> create(CreateStudentRequest request) {
        final var response = createStudentUseCase.execute(request);
        return ResponseEntity.created(URI.create("/student/" + response.id())).body(response);
    }

    @Override
    public List<FindStudentResponse> getAll() {
        return this.findAllStudentUseCase.execute();
    }

    @Override
    public FindStudentResponse getById(Long id) {
        return this.findByIdStudentUseCase.execute(id);
    }

    @Override
    public ResponseEntity<?> updateById(Long id, UpdateStudentRequest request) {
        final var response = this.updateStudentUseCase.execute(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> deactivateById(Long id) {
        final var response = this.updateStudentUseCase.execute(id, false);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> activateById(Long id) {
        final var response = this.updateStudentUseCase.execute(id, true);
        return ResponseEntity.ok(response);
    }

}
