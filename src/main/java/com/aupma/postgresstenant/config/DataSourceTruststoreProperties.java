package com.aupma.postgresstenant.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Pavith Madusara
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "global.datasource.truststore")
public class DataSourceTruststoreProperties {
    private String location;
    private String password;
    private String content;
    private String type;
}
