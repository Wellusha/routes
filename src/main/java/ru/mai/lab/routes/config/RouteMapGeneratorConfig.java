package ru.mai.lab.routes.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app.generator.route-map")
@Data
public class RouteMapGeneratorConfig {

    private static final int DEFAULT_ATM_COUNT = 1000;

    private static final int DEFAULT_MIN_DISTANCE = 1000;
    private static final int DEFAULT_MAX_DISTANCE = 5000;

    private static final double DEFAULT_MIN_EXPECTED = 1;
    private static final double DEFAULT_MAX_EXPECTED = 2;

    private static final double DEFAULT_MIN_DISPERSION = 0.5;
    private static final double DEFAULT_MAX_DISPERSION = 1;

    private Integer atmCount;
    private Integer routesCount;

    private Integer minDistance;
    private Integer maxDistance;

    private Double minExpected;
    private Double maxExpected;

    private Double minDispersion;
    private Double maxDispersion;

    public Integer getAtmCount() {
        return atmCount != null ? atmCount : DEFAULT_ATM_COUNT;
    }

    public Integer getRoutesCount() {
        return routesCount != null ? routesCount : getAtmCount() * getAtmCount();
    }

    public Integer getMinDistance() {
        return minDistance != null ? minDistance : DEFAULT_MIN_DISTANCE;
    }

    public Integer getMaxDistance() {
        return maxDistance != null ? maxDistance : DEFAULT_MAX_DISTANCE;
    }

    public Double getMinExpected() {
        return minExpected != null ? minExpected : DEFAULT_MIN_EXPECTED;
    }

    public Double getMaxExpected() {
        return maxExpected != null ? maxExpected : DEFAULT_MAX_EXPECTED;
    }

    public Double getMinDispersion() {
        return minDispersion != null ? minDispersion : DEFAULT_MIN_DISPERSION;
    }

    public Double getMaxDispersion() {
        return maxDispersion != null ? maxDispersion : DEFAULT_MAX_DISPERSION;
    }

}
