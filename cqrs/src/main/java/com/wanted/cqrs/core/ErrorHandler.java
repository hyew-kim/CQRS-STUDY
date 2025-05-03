package com.wanted.cqrs.core;

import com.wanted.cqrs.exception.AlertException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlertException.class)
    public ResponseEntity<ErrorResponse> handleException(AlertException ex) {
        log.info("AlertException: {}", ex.getErrorType().getHttpStatus());
        ErrorResponse response = new ErrorResponse(Error.builder()
                .code(ex.getErrorType().toString())
                .message(ex.getMessage())
                .details(ex.getDetails())
                .build());

        return ResponseEntity
                .status(ex.getErrorType().getHttpStatus())
                .body(response);
    }
}
