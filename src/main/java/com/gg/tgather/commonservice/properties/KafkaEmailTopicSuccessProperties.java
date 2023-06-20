package com.gg.tgather.commonservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("kafka.email-topic.success")
public class KafkaEmailTopicSuccessProperties {

    private String sendAuthenticationMailSuccessTopic;

}
