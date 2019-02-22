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

    public Questions getFullQuestion() {
        Map<String, String> out = new HashMap<>();

        try(Reader reader = Files.newBufferedReader(Paths.get(QuestionDaoSimple.class.getResource("/Quiz.csv").toURI()))) {

            CSVReader csvReader = new CSVReader(reader);

            String[] next;
            while ((next = csvReader.readNext()) != null) {
                out.put(next[0], next[1]);
            }

        } catch (IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }

        return new Questions(out);
    }
}
