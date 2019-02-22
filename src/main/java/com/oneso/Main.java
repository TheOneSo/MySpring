package com.oneso;

import com.oneso.domain.Person;
import com.oneso.domain.Questions;
import com.oneso.service.PersonService;
import com.oneso.service.QuestionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService qService = context.getBean(QuestionService.class);
        Questions questions = qService.getQuestions();

        PersonService pService = context.getBean(PersonService.class);
        Person person = pService.newPerson();

        questions.start();
        System.out.println("-------");
        System.out.println(person);

    }
}
