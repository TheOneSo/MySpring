package com.oneso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    private final MessageSource messageSource;

    @Value("${user.locale}")
    private Locale locale;

    @Autowired
    public LocalizationServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void setLocale(String language, String country) {
        locale = new Locale(language, country);
    }

    @Override
    public String getMessage(String text, Object[] args) {
        return messageSource.getMessage(text, args, locale);
    }

    @Override
    public String getMessage(String text) {
        return messageSource.getMessage(text, null, locale);
    }

    @Override
    public String getLanguage() {
        return locale.getLanguage();
    }
}
