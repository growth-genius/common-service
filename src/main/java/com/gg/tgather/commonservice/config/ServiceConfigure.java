package com.gg.tgather.commonservice.config;

import com.gg.tgather.commonservice.properties.JwtProperties;
import com.gg.tgather.commonservice.security.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ServiceConfigure {

    @Bean
    public Jwt jwt(JwtProperties jwtProperties) {
        return new Jwt(jwtProperties.getIssuer(), jwtProperties.getClientSecret());
    }

}
