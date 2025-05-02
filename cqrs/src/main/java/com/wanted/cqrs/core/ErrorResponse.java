package com.wanted.cqrs.core;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private boolean success;
    private Error error;

    public ErrorResponse(Error error) {
        this.success = false;
        this.error = error;
    }
}
