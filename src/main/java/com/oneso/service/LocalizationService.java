package com.oneso.service;

public interface LocalizationService {

    void setLocale(String language);

    String getMessageWithLocale(String bundleProp, Object[] args);

    String getLanguage();
}
