package com.gg.commonservice.advice.exceptions;

/**
 * 인증되지 않은 계정 예외처리
 */
public class RequiredAuthAccountException extends RuntimeException {

    public RequiredAuthAccountException() {
        super();
    }

    public RequiredAuthAccountException(String msg) {
        super(msg);
    }
}
