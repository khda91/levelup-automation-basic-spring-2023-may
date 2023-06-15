package ru.levelp.at.lesson0809.ser.deser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationApp {

    public static void main(String[] args) {
        try (var ois = new ObjectInputStream(new FileInputStream("example.txt"))) {
            var person = (Person) ois.readObject();
            System.out.println(person);
            person.setAge(21);
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
