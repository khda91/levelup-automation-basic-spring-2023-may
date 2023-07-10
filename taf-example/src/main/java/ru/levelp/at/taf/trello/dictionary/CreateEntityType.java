package ru.levelp.at.taf.trello.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CreateEntityType {

    CREATE_BOARD("Create board");

    private final String name;
}
