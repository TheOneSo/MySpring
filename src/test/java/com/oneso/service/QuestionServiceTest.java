package com.oneso.service;


import com.oneso.dao.QuestionsDao;
import com.oneso.domain.Questions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Сервис по работе с вопросами")
class QuestionServiceTest {

    @Mock
    private QuestionsDao questionsDao;
    @Mock
    private LocalizationService localizationService;

    private QuestionService service;

    @BeforeEach
    void setUp() {
        questionsDao = mock(QuestionsDao.class);
        when(questionsDao.parsQuestionCSV(isNull())).thenReturn(new Questions("1", "2"));
        when(questionsDao.parsQuestionCSV(anyString())).thenReturn(new Questions("1", "2"));
        service = new QuestionServiceImpl(questionsDao, localizationService);
    }

    @Test
    @DisplayName("парсит и вовращает вопросы")
    void getQuestionsTest() {
        assertNotNull(service.getQuestions());
    }
}
