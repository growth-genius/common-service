package com.sgyj.commonservice.dto.account;

import lombok.Data;

@Data
public class AccountDto {

    /** 고유 식별자 */
    private String accountId;
    /** 이메일 */
    private String email;
    /* 사용자 별명 */
    private String nickname;

}
