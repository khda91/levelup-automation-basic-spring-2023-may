package ru.levelp.at.lesson0809.ser.deser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationApp {

    public static void main(String[] args) {
        var person = new Person("user", "pass", 20);

        try (var oos = new ObjectOutputStream(new FileOutputStream("example.txt"))) {
            oos.writeObject(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
