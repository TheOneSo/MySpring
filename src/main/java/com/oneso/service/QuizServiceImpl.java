package com.oneso.service;

import com.oneso.domain.Person;
import com.oneso.domain.Questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    private final PersonService personService;
    private final QuestionService questionService;
    private final LocalizationService localizationService;

    @Autowired
    public QuizServiceImpl(PersonService personService, QuestionService questionService, LocalizationService localizationService) {
        this.personService = personService;
        this.questionService = questionService;
        this.localizationService = localizationService;
    }

    @Override
    public void runQuiz() {
        Person person = personService.newPerson();
        Questions questions = questionService.getQuestions();

        questionService.start(questions);

        System.out.println("--------");
        System.out.println(localizationService.getMessage("goodbye.user", new String[] {person.toString()}));
    }
}
