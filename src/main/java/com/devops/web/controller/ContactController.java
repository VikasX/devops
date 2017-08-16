package com.devops.web.controller;

import com.devops.backend.service.EmailService;
import com.devops.web.domain.frontend.FeedBackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.management.modelmbean.ModelMBean;

/**
 * Created by XxX on 7/19/2017.
 */
@Controller
public class ContactController {

    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
    public static final String FEEDBACK_MODEL_KEY = "feedback";

    public static final String CONTACT_US_VIEW_NAME = "contact/contact";

    @Autowired
    private EmailService emailService;

    @RequestMapping(value= "/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap m){
        FeedBackPojo f = new FeedBackPojo();
        m.addAttribute(ContactController.FEEDBACK_MODEL_KEY, f);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

    @RequestMapping(value="/contact", method=RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedBackPojo f){
        LOG.debug("Feedback XXXXXXXcontent{}", f);
        emailService.sendFeedbackEmail(f);
        return ContactController.CONTACT_US_VIEW_NAME;
    }
}
