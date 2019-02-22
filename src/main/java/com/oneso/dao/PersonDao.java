package com.oneso.dao;

import com.oneso.domain.Person;

public interface PersonDao {

    Person findPerson(String firstName, String lastName);

    Person newPerson();
}
