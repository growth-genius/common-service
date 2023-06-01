package com.gg.tgather.commonservice.dto.mail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailMessage {

    private String accountId;

    private String to;

    private MailSubject mailSubject;

    private String message;

    public String getSubject() {
        return mailSubject.getSubject();
    }

    public String getHtmlFileName() {
        return mailSubject.getHtmlFileName();
    }

    public EmailType getEmailType() {
        return mailSubject.getEmailType();
    }

}
