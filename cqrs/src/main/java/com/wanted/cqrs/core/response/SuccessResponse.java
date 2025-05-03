package com.wanted.cqrs.core.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SuccessResponse<E> extends BaseResponse {
    private final String message;
    private final E data;

    @Builder
    public SuccessResponse(String message, E data) {
        super(true);
        this.message = message;
        this.data = data;
    }
}
