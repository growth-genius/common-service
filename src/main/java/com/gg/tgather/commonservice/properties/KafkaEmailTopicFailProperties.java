package com.gg.tgather.commonservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("kafka.email-topic.fail")
public class KafkaEmailTopicFailProperties {

    private String sendAuthenticationMailFailTopic;

}
