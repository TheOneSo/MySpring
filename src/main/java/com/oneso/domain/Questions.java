package com.oneso.domain;

import java.util.Map;
import java.util.Scanner;

public class Questions {

    private final Map<String, String> question;

    public Questions(Map<String, String> question) {
        this.question = question;
    }

    public void start() {
        int current = 0;

        System.out.println("Ответьте пожалуйта на 5 вопросов:");

        Scanner in = new Scanner(System.in);

        for(Map.Entry<String, String> entry : question.entrySet()) {
            System.out.println("Вопрос " + entry.getKey());

            String temp = in.nextLine().trim();

            if(temp.toLowerCase().equals(entry.getValue().toLowerCase().trim())) {
                current++;
            }
        }

        System.out.printf("У вас %d правельных ответов!%n", current);
    }
}
