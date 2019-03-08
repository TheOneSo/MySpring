package com.oneso;

import com.oneso.service.QuizService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        QuizService quizService = context.getBean(QuizService.class);
        quizService.runQuiz();
    }
}
