package com.oneso.service;

import com.oneso.domain.Person;
import com.oneso.domain.Questions;

public class QuizServiceImpl implements QuizService {

    private final PersonService personService;
    private final QuestionService questionService;

    public QuizServiceImpl(PersonService personService, QuestionService questionService) {
        this.personService = personService;
        this.questionService = questionService;
    }

    @Override
    public void runQuiz() {
        Person person = personService.newPerson();
        Questions questions = questionService.getQuestions();

        questionService.start(questions);

        System.out.println("--------");
        System.out.println(person);
    }
}
