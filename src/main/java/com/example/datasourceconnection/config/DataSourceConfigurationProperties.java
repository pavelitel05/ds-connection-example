package com.example.datasourceconnection.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "ds")
public class DataSourceConfigurationProperties {
    private String user;
    private String password;
    private String driver;
    private String url;
    private String entityPackage;
}
