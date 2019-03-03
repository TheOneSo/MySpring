package com.oneso.dao;

import com.oneso.domain.Questions;

import java.util.Map;

public interface QuestionsDao {

    Questions parsQuestionCSV(String pathCsv);

    Map<String, String> getAllQuestions();

    void addQuestion(String question, String answer);
}
