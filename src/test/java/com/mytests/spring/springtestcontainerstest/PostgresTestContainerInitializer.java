package com.mytests.spring.springtestcontainerstest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class PostgresTestContainerInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final PostgreSQLContainer<?> POSTGRES =
            new PostgreSQLContainer<>(DockerImageName.parse("postgres:16"))
                    .withDatabaseName("testdb")
                    .withUsername("test")
                    .withPassword("test")
    .withInitScript("db/init.sql"); // optional

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        POSTGRES.start();

        Map<String, Object> props = new HashMap<>();
        props.put("spring.datasource.url", POSTGRES.getJdbcUrl());
        props.put("spring.datasource.username", POSTGRES.getUsername());
        props.put("spring.datasource.password", POSTGRES.getPassword());
        props.put("spring.datasource.driver-class-name", "org.postgresql.Driver");
        props.put("spring.test.database.replace", "NONE");

        ConfigurableEnvironment env = context.getEnvironment();
        env.getPropertySources().addFirst(new MapPropertySource("testcontainers", props));
    }
}