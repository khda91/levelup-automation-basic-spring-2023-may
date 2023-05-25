package ru.levelp.at.lesson03.unit.testing.tools.soft.assertions.service;

import java.time.LocalDate;

public class PersonService {

    public static Person createRandomPerson() {
        return new Person("Иван", "Иванов",
            LocalDate.now().minusYears(20), "i.ivanov@gmail.com");
    }
}
