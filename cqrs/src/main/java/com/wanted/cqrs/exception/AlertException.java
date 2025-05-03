package com.wanted.cqrs.exception;

import com.wanted.cqrs.core.ErrorType;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class AlertException extends RuntimeException {
    @Getter
    private final ErrorType errorType;
    @Getter
    private final Map<String, Object> details = new HashMap<>();

    public AlertException(ErrorType errorType) {
        super(errorType.getDescription());
        this.errorType = errorType;
    }

    public AlertException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public AlertException(ErrorType errorType, String message, Map<String, Object> details) {
        super(message);
        this.details.putAll(details);
        this.errorType = errorType;
    }

    public AlertException(ErrorType errorType, Throwable cause) {
        super(errorType.getDescription(), cause);
        this.errorType = errorType;
    }
}
