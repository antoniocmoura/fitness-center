package com.antoniocmoura.fitness.center.infrastructure.api.student;

import com.antoniocmoura.fitness.center.application.usecase.student.create.CreateStudentRequest;
import com.antoniocmoura.fitness.center.application.usecase.student.create.CreateStudentResponse;
import com.antoniocmoura.fitness.center.application.usecase.student.find.FindStudentResponse;
import com.antoniocmoura.fitness.center.application.usecase.student.update.UpdateStudentRequest;
import com.antoniocmoura.fitness.center.application.usecase.student.update.UpdateStudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "student")
@Tag(name = "student")
public interface StudentEndpoint {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreateStudentResponse.class))
                    }),
            @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> create(@Valid @RequestBody CreateStudentRequest request);

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listed successfully"),
            @ApiResponse(responseCode = "422", description = "A invalid parameter was received"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    @Operation(summary = "List all students")
    public List<FindStudentResponse> getAll();

    @GetMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get a student by it´s identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    FindStudentResponse getById(@PathVariable(name = "id") Long id);

    @PutMapping(
            value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a student by it´s identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UpdateStudentResponse.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Student was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> updateById(@PathVariable(name = "id") Long id, @RequestBody UpdateStudentRequest input);

    @PutMapping(
            value = "deactivate/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Deactivate student by it´s key value")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student successfully inactivated"),
            @ApiResponse(responseCode = "404", description = "Student was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> deactivateById(@PathVariable(name = "id") Long id);

    @PutMapping(
            value = "activate/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Deactivate student by it´s key value")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student successfully activated"),
            @ApiResponse(responseCode = "404", description = "Student was not found"),
            @ApiResponse(responseCode = "500", description = "An internal server error was thrown")
    })
    ResponseEntity<?> activateById(@PathVariable(name = "id") Long id);

}
