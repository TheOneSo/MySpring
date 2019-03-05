package com.oneso.dao;

import com.oneso.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование хранилища персон")
class PersonDaoTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Ivan", "Ivanov");
    }

    @Test
    @DisplayName("Новая персона создается корректно")
    void newPersonTest() {
        PersonDaoSimple personDaoSimple = new PersonDaoSimple();

        assertNotNull(personDaoSimple.newPerson("1", "2"));
    }

    @Test
    @DisplayName("Хранения персоны")
    void storagePersonTest() {
        PersonDaoSimple personDaoSimple = new PersonDaoSimple();
        personDaoSimple.newPerson("1", "2");

        assertNotNull(personDaoSimple.findPerson("1", "2"));
    }

    @Test
    @DisplayName("Новая персона существует")
    void getPersonTest() {
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.newPerson("Ivan", "Ivanov")).thenReturn(person);

        assertEquals(person, personDao.newPerson("Ivan", "Ivanov"));
    }

    @Test
    @DisplayName("Поиск персоны")
    void findPersonTest() {
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.findPerson("Ivan", "Ivanov")).thenReturn(person);

        assertEquals(person, personDao.findPerson("Ivan", "Ivanov"));
    }

}
