package com.gg.tgather.commonservice.infra.container;

import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

public class AbstractKafkaContainerBaseTest {

    protected static KafkaContainer KAFKA_CONTAINER;

    static {
        KAFKA_CONTAINER = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));
        KAFKA_CONTAINER.start();
    }

}
