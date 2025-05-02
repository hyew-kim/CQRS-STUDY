package com.wanted.cqrs.core;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Error {
    private String code;
    private String message;
}
