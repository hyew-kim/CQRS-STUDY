package com.wanted.cqrs.core.response;

import com.wanted.cqrs.core.Error;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse extends BaseResponse{
    private final Error error;

    @Builder
    public ErrorResponse(Error error) {
        super(false);
        this.error = error;
    }
}
