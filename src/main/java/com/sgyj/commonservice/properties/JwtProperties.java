package com.sgyj.commonservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("jwt")
public class JwtProperties {

    private String header;

    private String issuer;

    private String clientSecret;

    private String tokenValidityInMilliseconds;
}
