package com.oneso.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Конфигурация для локали")
class LocalizationConfigTest {

    @Test
    @DisplayName("корректно создает бин для конфигурации")
    void shouldCorrectCreateBeanForConfiguration() {
        LocalizationConfig config = new LocalizationConfig();

        assertNotNull(config.messageSource());
    }
}
