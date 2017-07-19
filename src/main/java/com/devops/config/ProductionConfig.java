package com.devops.config;

import com.devops.backend.service.EmailService;
import com.devops.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by XxX on 7/19/2017.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///D://XJAVA//devops//application-prod.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}