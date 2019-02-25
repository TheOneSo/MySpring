package com.oneso.service;

import com.oneso.domain.Questions;

public interface QuestionService {

    Questions getQuestions();

    void start(Questions questions);
}
