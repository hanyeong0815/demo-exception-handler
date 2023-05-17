package com.example.demo.member.excpetion;

import com.example.demo.common.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    DEFAULT("회원 관련 오류", HttpStatus.INTERNAL_SERVER_ERROR);

    public final String MESSAGE;
    public final HttpStatus STATUS;

    @Override
    public HttpStatus defaultHttpStatus() {
        return STATUS;
    }

    @Override
    public String defaultMessage() {
        return MESSAGE;
    }

    @Override
    public RuntimeException defaultException() {
        return new MemberException(this);
    }

    @Override
    public RuntimeException defaultException(Throwable cause) {
        return null;
    }
}
