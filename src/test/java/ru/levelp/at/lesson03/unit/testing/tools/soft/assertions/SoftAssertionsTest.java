package ru.levelp.at.lesson03.unit.testing.tools.soft.assertions;

import java.time.LocalDate;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.levelp.at.lesson03.unit.testing.tools.soft.assertions.service.PersonService;

public class SoftAssertionsTest {

    @Test
    void createRandomPersonTest() {
        var person = PersonService.createRandomPerson();

        var softAssert = new SoftAssert();

        softAssert.assertEquals(person.getFirstName(), "Иван");
        softAssert.assertEquals(person.getLastName(), "Иванов");
        softAssert.assertEquals(person.getDateOfBirth(), LocalDate.now().minusYears(20));
        softAssert.assertEquals(person.getEmail(), "i.ivanov@gmail.com");

        softAssert.assertAll();
    }

    @Test
    void createRandomPersonFailTest() {
        var person = PersonService.createRandomPerson();

        var softAssert = new SoftAssert();

        softAssert.assertEquals(person.getFirstName(), "Петр");
        softAssert.assertEquals(person.getLastName(), "Петров");
        softAssert.assertEquals(person.getDateOfBirth(), LocalDate.now().minusYears(25));
        softAssert.assertEquals(person.getEmail(), "i.ivanov@gmail.com");

        softAssert.assertAll();
    }

    @Test
    void createRandomPersonWithoutAsserAllTest() {
        var person = PersonService.createRandomPerson();

        var softAssert = new SoftAssert();

        softAssert.assertEquals(person.getFirstName(), "Петр");
        softAssert.assertEquals(person.getLastName(), "Петров");
        softAssert.assertEquals(person.getDateOfBirth(), LocalDate.now().minusYears(25));
        softAssert.assertEquals(person.getEmail(), "i.ivanov@gmail.com");
    }
}
