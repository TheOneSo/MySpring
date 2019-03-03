package com.oneso.service;

import com.oneso.dao.QuestionsDao;
import com.oneso.domain.Questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionsDao qDao;

    private final LocalizationService localizationService;

    @Value("${ru.path.quiz}")
    private String ruPathToCSV;

    @Value("${en.path.quiz}")
    private String enPathToCSV;

    @Autowired
    public QuestionServiceImpl(QuestionsDao qDao, LocalizationService localizationService) {
        this.qDao = qDao;
        this.localizationService = localizationService;
    }

    public Questions getQuestions() {

        switch (localizationService.getLanguage()) {
            case "ru": return qDao.parsQuestionCSV(ruPathToCSV);
            case "en": return qDao.parsQuestionCSV(enPathToCSV);
            default: return qDao.parsQuestionCSV("/en_Quiz.csv");
        }
    }

    public void start(Questions questions) {
        Map<String, String> question = questions.getQuestions();

        int current = 0;

        System.out.println(localizationService.getMessageWithLocale("welcome.quiz", new Object[] {question.size()}));

        Scanner in = new Scanner(System.in);

        for(Map.Entry<String, String> entry : question.entrySet()) {

            System.out.printf("%s: %s ", localizationService.getMessageWithLocale("question", null), entry.getKey());

            String temp = in.nextLine().trim();

            if(temp.toLowerCase().equals(entry.getValue().toLowerCase().trim())) {
                current++;
            }
        }

        System.out.println(localizationService.getMessageWithLocale("finnal.quiz", new Object[] {current}));
    }
}
