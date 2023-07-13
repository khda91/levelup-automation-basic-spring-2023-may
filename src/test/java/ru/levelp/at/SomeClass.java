package ru.levelp.at;

public class SomeClass {

    static String m(String s) {
        String value;
        if (s.contains("ssss")) {
            value = s.substring(10);
        } else {
            value = s;
        }
        return value;
    }
}
