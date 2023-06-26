package ru.levelp.at.lesson12.design.patterns.factory.method;

import java.util.Arrays;

public enum Browser {

    CHROME, FIREFOX, EDGE;

    public static Browser getBrowser(final String name) {
        return Arrays.stream(values())
                     .filter(browser -> name.equalsIgnoreCase(browser.name()))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Нет такого браузера в поддержке" + name + "."));
    }
}
