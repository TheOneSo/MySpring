package com.oneso.dao;

import com.oneso.BeanForTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BeanForTests.class)
@DisplayName("Тестирование хранилища опросника")
class QuestionDaoTest {

    @Value("${path.csv}")
    private String path;

    @Disabled
    @Test
    @DisplayName("Файл парсится корректно")
    void parsTest() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();
        questionDaoSimple.parsQuestionCSV(path);

        assertFalse(questionDaoSimple.getAllQuestions().isEmpty());
    }

    @Test
    @DisplayName("Опросник создан")
    void newQuestion() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();

        assertNotNull(questionDaoSimple.parsQuestionCSV("/Quiz.csv"));
    }

    @Test
    @DisplayName("Добавить 1 вопрос")
    void addQuestionTest() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();
        questionDaoSimple.addQuestion("1", "2");

        assertNotNull(questionDaoSimple.getAllQuestions());
    }

    @Test
    @DisplayName("Получить пустой опросник")
    void newVoidQuestion() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();

        assertNotNull(questionDaoSimple.getAllQuestions());
    }

    @Test
    @DisplayName("Добавление вопроса без ответа и наоборот")
    void addQuestionNotAnswer() {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();
        questionDaoSimple.addQuestion("1", null);

        assertNotNull(questionDaoSimple.getAllQuestions());

        questionDaoSimple.addQuestion(null, "1");

        assertNotNull(questionDaoSimple.getAllQuestions());
    }

    @Test
    @DisplayName("Парсинг документа с неправельным путем")
    void createQuestionsFailPath() throws NullPointerException {
        QuestionDaoSimple questionDaoSimple = new QuestionDaoSimple();

        Throwable throwable = assertThrows(NullPointerException.class, () ->
            questionDaoSimple.parsQuestionCSV("1") );

        assertNotNull(throwable);
    }
}
