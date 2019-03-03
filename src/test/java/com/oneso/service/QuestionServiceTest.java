package com.oneso.service;


import com.oneso.domain.Questions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование сервиса вопросника")
class QuestionServiceTest {

    @Test
    @DisplayName("Получение вопросов")
    void getQuestionsTest() {
        QuestionService questionService = mock(QuestionService.class);
        when(questionService.getQuestions()).thenReturn(new Questions(anyMap()));

        assertNotNull(questionService.getQuestions());
    }
}
