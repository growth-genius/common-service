package com.sgyj.commonservice.security;

import com.sgyj.commonservice.enums.LoginType;
import lombok.Data;

@Data
public class CredentialInfo {

    private String credential;
    private LoginType loginType;

    public CredentialInfo ( String password, LoginType loginType ) {
        this.credential = password;
        this.loginType = loginType;
    }

    public CredentialInfo ( String password ) {
        this.credential = password;
        this.loginType = LoginType.TGAHTER;
    }

}
