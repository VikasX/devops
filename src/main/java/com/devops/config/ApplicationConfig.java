package com.devops.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Column;

/**
 * Created by XxX on 7/22/2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.devops.backend.persistence.repos")
@EntityScan(basePackages = "com.devops.backend.persistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
