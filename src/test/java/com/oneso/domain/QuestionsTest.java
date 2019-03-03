package com.oneso.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование опросника")
class QuestionsTest {

    @Test
    @DisplayName("Проверка создания")
    void createQuestionsTest() {
        Questions questions = new Questions(new HashMap<>() {{put("test1", "test");}});
        Map<String, String> temp = new HashMap<>(){{put("test1", "test");}};

        assertEquals(temp, questions.getQuestions());
    }

    @Test
    @DisplayName("Проверка добавления теста")
    void addQuestionTest() {
        Questions questions = new Questions(new HashMap<>() {{put("test1", "test");}});
        questions.addQuestion("test2", "test");
        Map<String, String> temp = new HashMap<>(){{
            put("test1", "test");
            put("test2", "test");
        }};

        assertEquals(temp, questions.getQuestions());
    }
}
