package com.oneso.service;

import com.oneso.dao.PersonDao;
import com.oneso.domain.Person;

public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getPerson(String firstName, String lastName) {
        return dao.findPerson(firstName, lastName);
    }

    public Person newPerson() {
        return dao.newPerson();
    }
}
