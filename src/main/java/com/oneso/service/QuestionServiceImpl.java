package com.oneso.service;

import com.oneso.dao.QuestionsDao;
import com.oneso.domain.Questions;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionsDao qDao;

    public QuestionServiceImpl(QuestionsDao qDao) {
        this.qDao = qDao;
    }

    public Questions getQuestions() {
        return qDao.getFullQuestion();
    }
}
