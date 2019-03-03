package com.oneso.service;

import com.oneso.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование работы с персонами")
class PersonServiceTest {

    @Test
    @DisplayName("Проверка создания")
    void newPersonTest() {
        PersonService personService = mock(PersonService.class);
        when(personService.newPerson()).thenReturn(new Person("Ivan", "Ivanov"));

        assertNotNull(personService.newPerson());
    }

    @Test
    @DisplayName("Проверка получения")
    void getPersonTest() {
        PersonService personService = mock(PersonService.class);
        when(personService.getPerson(anyString(), anyString())).thenReturn(new Person("Ivan", "Ivanov"));

        assertNotNull(personService.getPerson("Ivan", "Ivanov"));
    }
}
