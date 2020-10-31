package ru.mai.lab.routes.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app.atm")
@Data
public class AtmConfig {

    private static final int DEFAULT_MIN_IN = 100;
    private static final int DEFAULT_MAX_IN = 500;

    private static final int DEFAULT_MIN_OUT = 100;
    private static final int DEFAULT_MAX_OUT = 500;

    private static final double DEFAULT_MIN_EXPECTED = 1;
    private static final double DEFAULT_MAX_EXPECTED = 2;

    private static final double DEFAULT_MIN_DISPERSION = 0.5;
    private static final double DEFAULT_MAX_DISPERSION = 1;

    private Integer minIn;
    private Integer maxIn;

    private Integer minOut;
    private Integer maxOut;

    private Double minExpected;
    private Double maxExpected;

    private Double minDispersion;
    private Double maxDispersion;

    public Integer getMinIn() {
        return minIn != null ? minIn : DEFAULT_MIN_IN;
    }

    public Integer getMaxIn() {
        return maxIn != null ? maxIn : DEFAULT_MAX_IN;
    }

    public Integer getMinOut() {
        return minOut != null ? minOut : DEFAULT_MIN_OUT;
    }

    public Integer getMaxOut() {
        return maxOut != null ? maxOut : DEFAULT_MAX_OUT;
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
