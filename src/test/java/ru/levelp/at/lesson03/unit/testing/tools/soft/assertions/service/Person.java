package ru.levelp.at.lesson03.unit.testing.tools.soft.assertions.service;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName)
            && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, email);
    }

    @Override
    public String toString() {
        return "Person{"
            + "firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", dateOfBirth=" + dateOfBirth
            + ", email='" + email + '\''
            + '}';
    }
}
