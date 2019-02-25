package com.oneso.dao;

import com.oneso.domain.Questions;
import com.opencsv.CSVReader;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class QuestionDaoSimple implements QuestionsDao {

    private Questions questions;

    public Questions parsQuestionCSV() {
        Map<String, String> out = new HashMap<>();

        try(Reader reader = Files.newBufferedReader(Paths.get(QuestionDaoSimple.class.getResource("/Quiz.csv").toURI()))) {

            CSVReader csvReader = new CSVReader(reader);

            String[] next;
            while ((next = csvReader.readNext()) != null) {
                // Пропускаем вопрос, в случае если нет ответа на него или нет вопроса к ответу
                if(next[0] != null && next[1] != null) {
                    out.put(next[0], next[1]);
                }
            }

        } catch (IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }

        questions = new Questions(out);
        return questions;
    }

    public Map<String, String> getAllQuestions() {
        return questions.getQuestions();
    }

    public void addQuestion(String question, String answer) {
        this.questions.addQuestion(question, answer);
    }
}
