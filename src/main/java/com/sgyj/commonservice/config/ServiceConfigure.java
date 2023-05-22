package com.sgyj.commonservice.config;

import com.sgyj.commonservice.properties.JwtProperties;
import com.sgyj.commonservice.security.Jwt;
import com.sgyj.commonservice.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfigure {

    @Bean
    public Jwt jwt(JwtProperties jwtProperties) {
        return new Jwt(jwtProperties.getIssuer(), jwtProperties.getSecret());
    }

}
