package ru.levelp.at.lesson1011.cicd.allure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {

    private final String name;
    private final String email;
    private final String password;
}
