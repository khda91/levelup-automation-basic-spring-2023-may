package ru.levelp.at.lesson12.design.patterns.singleton.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessengerEntity {

    private String id;
    private String personId;
    private String messengerId;
    private String nickname;
}
