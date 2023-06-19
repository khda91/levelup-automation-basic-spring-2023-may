package ru.levelp.at.lesson1011.cicd.allure.dictionary;

public enum PriorityLevel {

    LOW("low"),
    MEDIUM("medium"),
    HIGH("hihg");

    private final String value;

    PriorityLevel(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }
}
