package com.antoniocmoura.fitness.center.infrastructure.configuration.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseError {
    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String error;
}
