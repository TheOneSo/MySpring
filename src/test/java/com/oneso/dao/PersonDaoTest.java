package com.oneso.dao;

import com.oneso.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование хранилища персон")
class PersonDaoTest {

    @Test
    @DisplayName("Проверка создания новой персоны")
    void newPersonTest() {
        Person person = new Person("Ivan", "Ivanov");
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.newPerson("Ivan", "Ivanov")).thenReturn(person);

        assertEquals(person, personDao.newPerson("Ivan", "Ivanov"));
    }

    @Test
    @DisplayName("Провера поиска")
    void findPersonTest() {
        Person person = new Person("Ivan", "Ivanov");
        PersonDao personDao = mock(PersonDao.class);
        when(personDao.findPerson("Ivan", "Ivanov")).thenReturn(person);

        assertEquals(person, personDao.newPerson("Ivan", "Ivanov"));
    }

}
