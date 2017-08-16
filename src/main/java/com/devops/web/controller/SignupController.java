package com.devops.web.controller;

import com.devops.enums.PlanEnum;
import com.devops.web.domain.frontend.BasicAccountPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

/**
 * Created by XxX on 7/24/2017.
 */
@Controller
public class SignupController {

    private static final Logger LOG = LoggerFactory.getLogger(SignupController.class);

    public static final String SIGNUP_URL_MAPPING = "/signup";
    public static final String PAYLOAD_MODEL = "payload" ;
    public static final String SUBS_VIEW = "registration/signup";

    @RequestMapping(value = SIGNUP_URL_MAPPING, method = RequestMethod.GET)
    public String signupGet(@RequestParam("planId") int pid, ModelMap m){

        if(pid != PlanEnum.BASIC.getId()){
            throw new IllegalArgumentException("pid not found");
        }

        m.addAttribute(PAYLOAD_MODEL, new BasicAccountPayload());

        return SUBS_VIEW;
    }

}
