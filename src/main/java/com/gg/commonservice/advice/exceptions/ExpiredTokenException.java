package com.gg.commonservice.advice.exceptions;

public class ExpiredTokenException extends RuntimeException {

    public ExpiredTokenException() {
        super("토큰이 만료되었습니다.");
    }

    public ExpiredTokenException(String s) {
        super(s);
    }

}
