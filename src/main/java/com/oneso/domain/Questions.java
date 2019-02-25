package com.oneso.domain;

import java.util.Map;

public class Questions {

    private final Map<String, String> questions;

    public Questions(Map<String, String> question) {
        this.questions = question;
    }

    public void addQuestion(String question, String answer) {
        this.questions.put(question, answer);
    }

    public Map<String, String> getQuestions() {
        return questions;
    }
}
