package com.oneso.dao;

import com.oneso.domain.Person;

import java.util.Scanner;

public class PersonDaoSimple implements PersonDao {

    public Person findPerson(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }

    public Person newPerson() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите свое имя: ");
        String name = in.nextLine();
        System.out.println("Введите свою фамилию: ");
        String lastName = in.nextLine();

        return new Person(name, lastName);
    }
}
