package com.gg.commonservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("kafka.email-topic")
public class KafkaEmailTopicProperties {

    private String sendEmailFailTopic;
    private String sendEmailSuccessTopic;

}
