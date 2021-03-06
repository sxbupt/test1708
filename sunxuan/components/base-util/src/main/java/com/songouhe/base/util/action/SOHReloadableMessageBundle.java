package com.songouhe.base.util.action;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * Created by sunxuan on 16-7-20.
 */
public class SOHReloadableMessageBundle extends ReloadableResourceBundleMessageSource {
    private String[] basenames;
    private final static Logger logger = LoggerFactory.getLogger(SOHReloadableMessageBundle.class);
    public SOHReloadableMessageBundle(){
    }

    protected String getDefaultMessage(String code) {
        String messageToReturn = super.getDefaultMessage(code);
        if(!StringUtils.isBlank(messageToReturn) && messageToReturn.equals(code)) {
            this.logger.warn("The code [{}] cannot be found in the default language bundle and will be used as the message itself.", code);
        }

        return messageToReturn;
    }

    @Override
    protected String getMessageInternal(String code, Object[] args, Locale locale) {
            return super.getMessageInternal(code, args, locale);
        }
    public void setBasenames(String... basenames) {
        this.basenames = basenames;
            super.setBasenames(basenames);
        }
}
