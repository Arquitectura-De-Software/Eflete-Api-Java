package com.grupo4.eflete.Helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${custom.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${custom.datasource.url}")
    private String customDataSourceURL;
    @Value("${custom.datasource.username}")
    private String dbUsername;
    @Value("${custom.datasource.password}")
    private String dbPassword;

    @Primary
    @Bean
    public DataSource customDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(customDataSourceURL);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);

        return dataSource;

    }
}