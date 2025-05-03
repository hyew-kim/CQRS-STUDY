package com.wanted.cqrs.core.response;

import lombok.Getter;

@Getter
public class BaseResponse {
    private final boolean success;

    protected BaseResponse(boolean success) {
        this.success = success;
    }
}
