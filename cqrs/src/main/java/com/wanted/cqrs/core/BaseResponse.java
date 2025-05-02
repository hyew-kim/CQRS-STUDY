package com.wanted.cqrs.core;

import lombok.Data;

@Data
public class BaseResponse<E> {
    private boolean success;
    private String message;
    private E data;
}
