package com.example.datasourceconnection.config;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "hibernate")
public class HibernateConfigurationProperites {
    private String dialect;
    private String showSql;
    private String hbm2ddlAuto;

    public Properties getAdditionalProperties(){
        Properties properties = new Properties();
        properties.setProperty("hbm2ddl.auto", hbm2ddlAuto);
        properties.setProperty("show_sql", showSql);
        return properties;
    }
}
