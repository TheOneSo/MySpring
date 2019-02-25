package com.oneso.service;

import com.oneso.dao.QuestionsDao;
import com.oneso.domain.Questions;

import java.util.Map;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionsDao qDao;

    public QuestionServiceImpl(QuestionsDao qDao) {
        this.qDao = qDao;
    }

    public Questions getQuestions() {
        return qDao.parsQuestionCSV();
    }

    public void start(Questions questions) {
        Map<String, String> question = questions.getQuestions();

        int current = 0;

        System.out.println("Ответьте пожалуйта на 5 вопросов:");

        Scanner in = new Scanner(System.in);

        for(Map.Entry<String, String> entry : question.entrySet()) {

            System.out.printf("Вопрос %s: ", entry.getKey());

            String temp = in.nextLine().trim();

            if(temp.toLowerCase().equals(entry.getValue().toLowerCase().trim())) {
                current++;
            }
        }

        System.out.printf("У вас %d правельных ответов!%n", current);
    }
}
