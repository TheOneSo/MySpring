package com.oneso.spring_01;

import com.oneso.dao.PersonDao;
import com.oneso.dao.PersonDaoSimple;
import com.oneso.domain.Person;
import com.oneso.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonTests {

    @Test
    void person() {
        Person personTest = new Person("Ivan", "Ivanov");

        Person result = new PersonDaoSimple().findPerson("Ivan", "Ivanov");
        assertEquals(personTest.toString(), result.toString());
    }

    @Test
    void personService() {
        String name = "Ivan";
        String lastName = "Ivanov";
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.findPerson(name, lastName)).thenReturn(new Person(name, lastName));

        Person result = new PersonServiceImpl(personDao).getPerson(name, lastName);

        assertEquals("Ivan Ivanov", result.toString());

    }
}
