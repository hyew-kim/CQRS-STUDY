package com.wanted.cqrs.core.response;

import lombok.Getter;

@Getter
public class BaseResponse {
    private final boolean success;

    public BaseResponse(boolean success) {
        this.success = success;
    }
}
