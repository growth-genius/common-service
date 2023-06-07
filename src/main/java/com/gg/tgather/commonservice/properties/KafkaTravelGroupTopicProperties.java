package com.gg.tgather.commonservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("kafka.travel-group-topic")
public class KafkaTravelGroupTopicProperties {

    private String sendRequestJoinTravelGroupTopic;
}
