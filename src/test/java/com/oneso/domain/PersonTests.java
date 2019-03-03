package com.oneso.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестирование Person")
class PersonTests {

    @Test
    @DisplayName("Создание объекта")
    void createPerson() {
        Person person = new Person("Ivan", "Ivanov");

        assertEquals("Ivan Ivanov", person.toString());
    }

    @Test
    @DisplayName("Проверка имен и фамилии")
    void fullNameTest() {
        Person person = new Person("Ivan", "Ivanov");

        assertEquals("Ivan", person.getFirstName());
        assertEquals("Ivanov", person.getLastName());
    }

}
