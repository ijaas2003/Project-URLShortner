package com.urlshitt.shit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
  @Value("${spring.datasource.url}")
  private String dbUrl;
  @Value("${spring.datasource.username}")
  private String dbUsername;

  @Value("${spring.datasource.password}")
  private String dbPassword;

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(dbUrl);
    dataSource.setUsername(dbUsername);
    dataSource.setPassword(dbPassword);
    return dataSource;
  }
}
