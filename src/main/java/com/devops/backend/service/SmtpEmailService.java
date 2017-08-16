package com.devops.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by XxX on 7/19/2017.
 */
public class SmtpEmailService extends AbstractEmailService{
    
    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    private MailSender ms;

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage m) {

        LOG.debug("Sending EMAIL------{}", m);
        ms.send(m);
        LOG.info("Email Sent");
    }
}
