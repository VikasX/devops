package com.devops.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by XxX on 7/19/2017.
 */
public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
    
    @Override
    public void sendGenericEmailMessage(SimpleMailMessage m) {
        LOG.debug("Simulationg EMail----------");
        LOG.info(m.toString());
        LOG.debug("Mail sent");
    }
}
