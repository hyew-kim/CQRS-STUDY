package com.wanted.cqrs.core;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class Error {
    private String code;
    private String message;
    private Map<String, Object> details;
}
