package ru.levelp.at.taf.trello.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import ru.levelp.at.taf.trello.dictionary.CreateEntityType;
import ru.levelp.at.taf.trello.pages.BoardPage;
import ru.levelp.at.taf.trello.pages.BoardsPage;

public class BoardsSteps {

    private final BoardsPage boardsPage;
    private final BoardPage boardPage;

    public BoardsSteps() {
        this.boardsPage = new BoardsPage();
        this.boardPage = new BoardPage();
    }

    public void createBoard(String boardName) {
        boardsPage.createButton.click();
        boardsPage.createEntity(CreateEntityType.CREATE_BOARD).click();
        boardsPage.boardNameTextField.sendKeys(boardName);
        boardsPage.createEntityButton.click();
    }

    public void assertThatNewBoardWasCreated(String expectedBoardName) {
        boardPage.title.shouldHave(Condition.text(expectedBoardName));
    }

    public void openBoard(final String name) {
        boardsPage.boardCard(name).click();
    }

    public void addListItemToBoard(final String itemName) {
        boardPage.addAListButton.click();
        boardPage.addListItemTextBox.sendKeys(itemName);
        boardPage.addListButton.click();
    }

    public void assertThatItemWasAddedToBoard(final String expectedText) {
        boardPage.listItemCards.shouldHave(CollectionCondition.itemWithText(expectedText));
    }
}
