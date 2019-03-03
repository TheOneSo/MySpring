package com.oneso.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование сервиса локализации")
class LocalizationServiceTest {

    @Test
    @DisplayName("Проверка смены языка")
    void setLanguageTest() {
        LocalizationService localizationService = mock(LocalizationService.class);
        localizationService.setLocale("ru");

        assertEquals("ru", localizationService.getLanguage());
    }

    @Test
    @DisplayName("Проверка вывода сообщения в нужном языке")
    void getMessageWithLocaleTest() {
        LocalizationService localizationService = mock(LocalizationService.class);
        when(localizationService.getMessageWithLocale("newUser.firstName", null)).thenReturn("Введите ваше имя");
        localizationService.setLocale("ru");

        assertEquals("Введите ваше имя", localizationService.getMessageWithLocale("newUser.firstName", null));
    }
}
