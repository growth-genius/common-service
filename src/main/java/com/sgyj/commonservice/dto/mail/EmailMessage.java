package com.sgyj.commonservice.dto.mail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailMessage {

    private Long accountId;

    private String to;

    private MailSubject mailSubject;

    private String message;

    public String getSubject() {
        return mailSubject.getSubject();
    }

    public String getHtmlCode() {
        return mailSubject.getHtmlCode();
    }

    public EmailType getEmailType() {
        return mailSubject.getEmailType();
    }

}
