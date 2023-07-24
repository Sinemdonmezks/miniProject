package com.example.ksdproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    GNR_0001(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error."),
    GNR_0002(HttpStatus.NOT_FOUND, "Object not found."),
    GNR_0003(HttpStatus.CONFLICT, "Already exists."),
    GNR_0004(HttpStatus.BAD_REQUEST, "Equipment and period required.")
    ;

    private final HttpStatus httpStatus;
    private final String description;

    ErrorCode(HttpStatus httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }
}