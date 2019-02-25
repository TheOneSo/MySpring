package com.oneso.service;

import com.oneso.dao.PersonDao;
import com.oneso.domain.Person;

import java.util.Scanner;

public class PersonServiceImpl implements PersonService {

    private final PersonDao pDao;

    public PersonServiceImpl(PersonDao dao) {
        this.pDao = dao;
    }

    public Person getPerson(String firstName, String lastName) {
        return pDao.findPerson(firstName, lastName);
    }

    public Person newPerson() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите свое имя: ");
        String firstName = in.nextLine();
        System.out.print("Введите свою фамилию: ");
        String lastName = in.nextLine();

        return pDao.newPerson(firstName, lastName);
    }
}
