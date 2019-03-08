package com.oneso.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:test.properties")
@ContextConfiguration(classes = QuizConfigTest.class)
@DisplayName("Конфигурация викторины")
class QuizConfigTest {

    @Value("${test}")
    String text;

    @Test
    @DisplayName("корректно создается")
    void shouldCorrectCreator() {
        QuizConfig config = new QuizConfig();

        assertNotNull(config);
    }

    @Test
    @DisplayName("читает пропери")
    void shouldReadProperty() {
        String test = text;

        assertNotNull(test);
    }

    @Test
    @DisplayName("проверяет, что в проверти то что надо")
    void shouldProperty() {
        assertEquals("test", text);
    }
}
