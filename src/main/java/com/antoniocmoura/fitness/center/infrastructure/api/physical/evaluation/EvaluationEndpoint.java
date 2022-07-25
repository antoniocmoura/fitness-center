package com.antoniocmoura.fitness.center.infrastructure.api.physical.evaluation;

import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create.CreateEvaluationRequest;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.create.CreateEvaluationResponse;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.findall.FindAllEvaluationResponse;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.get.FindByIdEvaluationResponse;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update.UpdateEvaluationRequest;
import com.antoniocmoura.fitness.center.application.usecase.physical.evaluation.update.UpdateEvaluationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "evaluation")
@Tag(name = "physical evaluation")
public interface EvaluationEndpoint {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new physical evaluation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreateEvaluationResponse.class))
                    }),
            @ApiResponse(responseCode = "409", description = "Student was not found"),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> create(@Valid @RequestBody CreateEvaluationRequest request);

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listed successfully"),
            @ApiResponse(responseCode = "422", description = "A invalid parameter was received"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    @Operation(summary = "List all physical evaluation")
    public List<FindAllEvaluationResponse> getAll();

    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get a physical evaluation by it´s identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Physical evaluation retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Physical evaluation was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    FindByIdEvaluationResponse getById(@PathVariable(name = "id") Long id);

    @PutMapping(
            value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a physical evaluation by it´s identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Physical Evaluation updated successfully",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UpdateEvaluationResponse.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Physical Evaluation was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> updateById(@PathVariable(name = "id") Long id, @RequestBody UpdateEvaluationRequest input);

    @DeleteMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Delete a bank account by it´s identifier")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Physical Evaluation deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Physical Evaluation was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    void deleteById(@PathVariable(name = "id") Long id);
}
