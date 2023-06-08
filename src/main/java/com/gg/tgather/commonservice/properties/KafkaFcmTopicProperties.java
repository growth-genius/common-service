package com.gg.tgather.commonservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("kafka.fcm-topic")
public class KafkaFcmTopicProperties {

    private String sendSingleFcmTopic;
    private String sendMultipleFcmTopic;

}
