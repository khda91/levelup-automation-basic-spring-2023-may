package ru.levelp.at.lesson03.unit.testing.tools.soft.assertions;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import org.testng.annotations.Test;
import ru.levelp.at.lesson03.unit.testing.tools.soft.assertions.service.PersonService;

public class HardAssertionsTest {

    @Test
    void createRandomPersonTest() {
        var person = PersonService.createRandomPerson();

        assertEquals(person.getFirstName(), "Иван");
        assertEquals(person.getLastName(), "Иванов");
        assertEquals(person.getDateOfBirth(), LocalDate.now().minusYears(20));
        assertEquals(person.getEmail(), "i.ivanov@gmail.com");
    }

    @Test
    void createRandomPersonFailTest() {
        var person = PersonService.createRandomPerson();

        assertEquals(person.getFirstName(), "Иван");
        assertEquals(person.getLastName(), "Петров");
        assertEquals(person.getDateOfBirth(), LocalDate.now().minusYears(25));
        assertEquals(person.getEmail(), "i.ivanov@gmail.com");
    }
}
