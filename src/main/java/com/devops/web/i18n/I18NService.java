package com.devops.web.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by XxX on 7/18/2017.
 */
@Service
public class I18NService {

    private static final Logger LOG = LoggerFactory.getLogger(I18NService.class);
    
    @Autowired
    private MessageSource ms;

    public String getMsg(String mID){
        LOG.info("Log test XXXXXXXXXXXX{}", mID);
        Locale l = LocaleContextHolder.getLocale();
        return getMsg(mID,l);
    }
    public String getMsg(String mID, Locale l){
        return ms.getMessage(mID, null,l);
    }
}
