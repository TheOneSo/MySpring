package com.oneso.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.MessageSource;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование сервиса локализации")
class LocalizationServiceTest {

    @Mock
    private MessageSource messageSource;

    @Test
    @DisplayName("Получение языка языка")
    void getLanguageTest() {
        LocalizationService local = new LocalizationServiceImpl(messageSource, "ru", "RU");

        assertEquals("ru", local.getLanguage());
    }

    @Test
    @DisplayName("Проверка смены языка")
    void setLanguageTest() {
        LocalizationService local = new LocalizationServiceImpl(messageSource, "ru", "RU");
        local.setLocale("en", "US");

        assertEquals("en", local.getLanguage());
    }

    @Test
    @DisplayName("Получение сообщения")
    void getMessageTest() {
        LocalizationService local = mock(LocalizationService.class);
        when(local.getMessage("text")).thenReturn("text");

        assertEquals("text", local.getMessage("text"));
    }

    @Test
    @DisplayName("Получение сообщения с параметрами")
    void getMessageWithArgs() {
        LocalizationService local = mock(LocalizationService.class);
        when(local.getMessage("text {0}", new Object[] {"1"})).thenReturn("text 1");

        assertEquals("text 1", local.getMessage("text {0}", new Object[] {"1"}));
    }

    @Test
    @DisplayName("Проверка вывода сообщения в нужном языке")
    void getMessageWithLocaleTest() {
        LocalizationService localizationService = mock(LocalizationService.class);
        when(localizationService.getMessage("hello.user")).thenReturn("Привет пользователь");
        localizationService.setLocale("ru", "RU");

        assertEquals("Привет пользователь", localizationService.getMessage("hello.user"));
    }
}
