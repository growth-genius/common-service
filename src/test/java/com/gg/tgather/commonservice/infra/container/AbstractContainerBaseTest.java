package com.gg.tgather.commonservice.infra.container;

import lombok.RequiredArgsConstructor;
import org.testcontainers.containers.PostgreSQLContainer;

@RequiredArgsConstructor
public class AbstractContainerBaseTest {

    static final PostgreSQLContainer POSTGRE_SQL_CONTAINER;

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres");
        POSTGRE_SQL_CONTAINER.start();
    }

}

