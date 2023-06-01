package com.gg.tgather.commonservice.dto.mail;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EmailResult {

    /** 요청자 아이디 */
    private String accountId;
    /** 전송 상태 */
    private EmailSendStatus emailSendStatus;
    /** 변경 시간 */
    private LocalDateTime modifiedDt;

}
