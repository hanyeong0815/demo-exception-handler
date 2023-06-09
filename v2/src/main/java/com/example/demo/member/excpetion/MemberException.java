package com.example.demo.member.excpetion;

import com.example.demo.common.support.exception.CustomException;
import com.example.demo.common.support.exception.ErrorCode;

public class MemberException extends CustomException {
    public MemberException() {
        super();
    }

    public MemberException(String message) {
        super(message);
    }

    public MemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }

    public MemberException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
