package ru.levelp.at.lesson0809.ser.deser;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private String username;
    private String password;
    private Integer age;

    public Person() {

    }

    public Person(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        return Objects.equals(username, person.username) && Objects.equals(password, person.password) && Objects.equals(
            age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, age);
    }

    @Override
    public String toString() {
        return "Person{"
            + "username='" + username + '\''
            + ", password='" + password + '\''
            + ", age=" + age
            + '}';
    }
}
