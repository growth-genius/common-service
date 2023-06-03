package com.gg.tgather.commonservice.advice.exceptions;

/**
 * 필수 파라미터 누락 예외 처리
 */
public class OmittedRequireFieldException extends RuntimeException {

    public OmittedRequireFieldException(String msg, Throwable t) {
        super(msg, t);
    }

    public OmittedRequireFieldException(String msg) {
        super(msg);
    }

    public OmittedRequireFieldException() {
        super();
    }
}

