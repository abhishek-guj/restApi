package com.assignment.restApi.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ApiErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private Object details;

    public ApiErrorResponse(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}
