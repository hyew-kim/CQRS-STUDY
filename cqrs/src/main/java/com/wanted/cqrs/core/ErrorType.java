package com.wanted.cqrs.core;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    INVALID_INPUT("잘못된 입력 데이터", HttpStatus.BAD_REQUEST.value())
    , RESOURCE_NOT_FOUND("요청한 리소스를 찾을 수 없음", HttpStatus.NOT_FOUND.value())
    , UNAUTHORIZED("인증되지 않은 요청", HttpStatus.UNAUTHORIZED.value())
    , FORBIDDEN("권한이 없는 요청", HttpStatus.FORBIDDEN.value())
    , CONFLICT("리소스 충돌 발생", HttpStatus.CONFLICT.value())
    , INTERNAL_ERROR("서버 내부 오류", HttpStatus.INTERNAL_SERVER_ERROR.value());
    private final String message;
    private final int httpStatusCode;

    ErrorType(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    public static HttpStatus getHttpStatus(ErrorType errorType) {
        return HttpStatus.valueOf(errorType.getHttpStatusCode());
    }
}
