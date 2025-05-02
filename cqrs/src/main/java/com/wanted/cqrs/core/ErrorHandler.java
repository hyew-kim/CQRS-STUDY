package com.wanted.cqrs.core;

import com.wanted.cqrs.exception.AlertException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler(AlertException.class)
    public ResponseEntity<ErrorResponse> handleException(AlertException ex) {
        log.info("AlertException: {}", ErrorType.getHttpStatus(ex.getErrorType()));
        return ResponseEntity
                .status(ErrorType.getHttpStatus(ex.getErrorType()))
                .body(new ErrorResponse(Error.builder()
                        .code(ex.getErrorType().toString())
                        .message(ex.getErrorType().getMessage())
                        .build()));
    }
}
