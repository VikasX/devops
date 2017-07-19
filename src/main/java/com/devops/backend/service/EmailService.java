package com.devops.backend.service;

import com.devops.web.domain.frontend.FeedBackPojo;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by XxX on 7/19/2017.
 */
public interface EmailService {

    public void sendFeedbackEmail(FeedBackPojo f);

    public void sendGenericEmailMessage(SimpleMailMessage m);
}
