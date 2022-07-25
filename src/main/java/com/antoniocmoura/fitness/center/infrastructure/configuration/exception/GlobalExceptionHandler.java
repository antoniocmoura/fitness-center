package com.antoniocmoura.fitness.center.infrastructure.configuration.exception;

import com.antoniocmoura.fitness.center.application.exception.ApplicationException;
import com.antoniocmoura.fitness.center.application.exception.NotFoundException;
import com.antoniocmoura.fitness.center.application.exception.ValidationException;
import com.antoniocmoura.fitness.center.domain.exception.DomainException;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Resource
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String status, String message, HttpStatus statusCode) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus(status);
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

    @ExceptionHandler(value = Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception ex, WebRequest request) {
        if (ex.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) ex;
            return handleApplicationException((ApplicationException) exception.getUndeclaredThrowable(), request);
        } else {
            final String message = ex.getLocalizedMessage();
            ResponseError error = responseError("error", message, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(WebRequest request, DataIntegrityViolationException ex) {
        final String rootMsg = ex.getRootCause().getMessage();
        final String errorMsg = rootMsg.substring(rootMsg.indexOf("\n"), rootMsg.length()).trim();
        ResponseError error = responseError("validation error", errorMsg, HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, Locale locale) {
        List<FieldError> errorMessages = ex.getConstraintViolations()
                .stream()
                .map(FieldError::from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(ValidationError.newError(errorMessages), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {ApplicationException.class})
    private ResponseEntity<Object> handleApplicationException(ApplicationException ex, WebRequest request) {
        ResponseError error = responseError("error", ex.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {ValidationException.class})
    private ResponseEntity<Object> handleValidationException(ValidationException ex, WebRequest request) {
        ResponseError error = responseError("validation error", ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        ResponseError error = responseError("error", ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DomainException.class})
    public ResponseEntity<?> handleDomainException(DomainException ex) {
        ResponseError error = responseError("validation error", ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        return new ResponseEntity<>(error,  HttpStatus.UNPROCESSABLE_ENTITY);
    }

}