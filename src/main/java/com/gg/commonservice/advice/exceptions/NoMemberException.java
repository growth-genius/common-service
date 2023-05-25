package com.gg.commonservice.advice.exceptions;

/**
 * 미등록 회원 예외처리
 */
public class NoMemberException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1291658484551919953L;

    public NoMemberException() {super("존재하는 계정이 없습니다.");}

    public NoMemberException(String msg, Throwable t) {
        super(msg, t);
    }

    public NoMemberException(String msg) {
        super(msg);
    }


}
