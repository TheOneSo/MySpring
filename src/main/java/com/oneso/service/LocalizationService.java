package com.oneso.service;

public interface LocalizationService {

    void setLocale(String language, String country);

    String getMessage(String text, Object[] args);

    String getMessage(String text);

    String getLanguage();
}
