package com.oneso.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    private final MessageSource messageSource;

    private Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = Locale.US;
    }

    @Override
    public void setLocale(String language) {

        switch (language) {
            case "ru": locale = new Locale("ru", "RU"); break;
            case "en": locale = Locale.US; break;
            default: locale = Locale.US;
        }
    }

    @Override
    public String getMessageWithLocale(String bundleProp, Object[] args) {
        return messageSource.getMessage(bundleProp, args, locale);
    }

    @Override
    public String getLanguage() {
        return locale.getLanguage();
    }
}
