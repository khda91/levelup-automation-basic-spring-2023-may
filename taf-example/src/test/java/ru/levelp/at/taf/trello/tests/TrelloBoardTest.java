package ru.levelp.at.taf.trello.tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class TrelloBoardTest extends AbstractBaseTest {

    @Test(description = "Создание новой доски Trello")
    public void createNewBoard() {
        final var boardTitle = FAKER.beer().name();

        Selenide.open("");
        loginSteps.login(UI_CONFIG.username(), UI_CONFIG.password());

        boardsSteps.createBoard(boardTitle);

        boardsSteps.assertThatNewBoardWasCreated(boardTitle);
    }

    @Test(description = "Добавляем item на доску")
    public void addItemToBoard() {
        final var boardTitle = FAKER.beer().name();
        boardsRestClient.createBoard(boardTitle);

        Selenide.open("");
        loginSteps.login(UI_CONFIG.username(), UI_CONFIG.password());
        boardsSteps.openBoard(boardTitle);

        final var item = FAKER.name().name();
        boardsSteps.addListItemToBoard(item);
        boardsSteps.assertThatItemWasAddedToBoard(item);
    }
}
