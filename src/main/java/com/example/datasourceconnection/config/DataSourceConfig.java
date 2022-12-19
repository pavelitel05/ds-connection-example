package com.example.datasourceconnection.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final DataSourceConfigurationProperties dsCfg;
    private final HibernateConfigurationProperites hCfg;

    @Autowired
    public DataSourceConfig(DataSourceConfigurationProperties dsCfg, HibernateConfigurationProperites hCfg) {
        this.dsCfg = dsCfg;
        this.hCfg = hCfg;
    }

    @Bean
    public DataSource datasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dsCfg.getDriver());
        dataSource.setPassword(dsCfg.getPassword());
        dataSource.setUrl(dsCfg.getUrl());
        dataSource.setUsername(dsCfg.getUser());
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(datasource());
        entityManager.setPackagesToScan(dsCfg.getEntityPackage());
        var vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(hCfg.getDialect());
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaProperties(hCfg.getAdditionalProperties());
        return entityManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
