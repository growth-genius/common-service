package com.gg.commonservice.dto.mail;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MailSubject {

    VALID_AUTHENTICATION_ACCOUNT(EmailType.AUTHENTICATION_ACCOUNT, "TGather 회원가입 인증 메일", "validAuthenticationMail"),
    CONFIRM_JOIN_MEMBER(EmailType.JOIN_GROUP, "TravelGroup 가입 요청 메일", "confirmJoinMemberMail");

    private final EmailType emailType;
    private final String subject;
    private final String htmlFileName;

}
