package com.gg.commonservice.enums;

public enum ErrorMessage {


    WRONG_VALUE("wrong.value"),
    NEW_PASSWORD("입력한 새 패스워드가 일치하지 않습니다."),
    NOT_MATCHED_ACCOUNT("해당 정보와 일치하는 계정이 없습니다."),
    VERIFY_EMAIL("이메일 인증을 거치지 않은 사용자 입니다. 이메일 인증을 먼저 진행해 주세요."),
    PASSWORD_PATTERN("숫자와 영문자, 특수 문자 조합으로 8~12자리를 사용해야 합니다."),
    VALIDATE_REFRESH_TOKEN("기간이 만료된 토큰입니다. 재 로그인 해 주세요."),
    ;
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
