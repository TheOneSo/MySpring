package com.oneso;

import com.oneso.service.LocalizationService;
import com.oneso.service.QuizService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        LocalizationService ls = context.getBean(LocalizationService.class);
        ls.setLocale("ru");

        QuizService quizService = context.getBean(QuizService.class);
        quizService.runQuiz();
    }
}
