package ru.mai.lab.routes.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app.collector")
@Data
public class CollectorConfig {

    private static final int DEFAULT_COUNT = 5;

    private Integer count;

    public Integer getCount() {
        return count != null ? count : DEFAULT_COUNT;
    }

}
