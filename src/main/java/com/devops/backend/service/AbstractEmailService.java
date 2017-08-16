package com.devops.backend.service;

import com.devops.web.domain.frontend.FeedBackPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by XxX on 7/19/2017.
 */
public abstract class AbstractEmailService implements EmailService {

    @Value("${default.to.address}")
    private String defaultToAddress;

    protected SimpleMailMessage prepareMailFromPojo(FeedBackPojo f){
        SimpleMailMessage m = new SimpleMailMessage();
        m.setTo(defaultToAddress);
        m.setFrom(f.getEmail());
        m.setSubject("[Devops]: FeedBAck received From XXX");
        m.setText(f.getFeedback());
        return m;
    }

    @Override
    public void sendFeedbackEmail(FeedBackPojo f){
        sendGenericEmailMessage(prepareMailFromPojo(f));
    }
}
