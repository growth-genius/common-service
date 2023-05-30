package com.gg.commonservice.dto.mail;

public enum EmailSendStatus {

    PENDING("전송"),
    SUCCESS("성공"),
    FAIL("실패"),
    ;
    private final String status;

    EmailSendStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
}
