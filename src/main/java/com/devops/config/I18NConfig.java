package com.devops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by XxX on 7/18/2017.
 */
@Configuration
public class I18NConfig {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource r = new ReloadableResourceBundleMessageSource();
        r.setBasename("classpath:i18n/messages");

        //Check for new msg every 30min
        r.setCacheSeconds(1800);
        return r;
    }
}
