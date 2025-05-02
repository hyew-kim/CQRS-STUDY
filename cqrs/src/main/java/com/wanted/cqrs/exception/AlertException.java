package com.wanted.cqrs.exception;

import com.wanted.cqrs.core.ErrorType;
import lombok.Getter;

public class AlertException extends RuntimeException {
    @Getter
    private final ErrorType errorType;

    public AlertException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public AlertException(ErrorType errorType, Throwable cause) {
        super(errorType.getMessage(), cause);
        this.errorType = errorType;
    }
}
