package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class UserDtoWithLombokBuilder {

    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
}
