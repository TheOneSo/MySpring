package com.oneso.service;

import com.oneso.domain.Person;

public interface PersonService {

    Person getPerson(String firstName, String lastName);

    Person newPerson();
}
