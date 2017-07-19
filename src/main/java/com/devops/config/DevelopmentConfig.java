package com.devops.config;

import com.devops.backend.service.EmailService;
import com.devops.backend.service.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by XxX on 7/19/2017.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///D://XJAVA//devops//application-dev.properties")
public class DevelopmentConfig {

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
