package com.oneso.dao;

import com.oneso.domain.Questions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование хранилища опросника")
class QuestionDaoTest {

    @Test
    @DisplayName("Парсинг CSV")
    void parsCSVTest() {
        QuestionsDao questionsDao = mock(QuestionsDao.class);
        when(questionsDao.parsQuestionCSV(anyString())).thenReturn(new Questions(anyMap()));

        assertNotNull(questionsDao.parsQuestionCSV("path"));
    }

    @Test
    @DisplayName("Добавить новый вопрос")
    void addQuestionTest() {
        QuestionsDao questionsDao = mock(QuestionsDao.class);
        questionsDao.addQuestion(anyString(), anyString());

        assertNotNull(questionsDao.getAllQuestions());
    }
}
