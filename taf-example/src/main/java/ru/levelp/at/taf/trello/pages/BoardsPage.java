package ru.levelp.at.taf.trello.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import ru.levelp.at.taf.trello.dictionary.CreateEntityType;

public class BoardsPage {

    private static final String CREATE_ENTITY_LOCATOR = "//button[.//span[text()='%s']]";
    private static final String BOARD_CARD_LOCATOR = "//a[.//div[contains(text(), '%s')]]";

    public SelenideElement createButton = $x("//button[@data-testid='header-create-menu-button']");
    public SelenideElement boardNameTextField = $x("//*[@data-testid='create-board-title-input']");
    public SelenideElement createEntityButton = $x("//*[@data-testid='create-board-submit-button']");

    public SelenideElement createEntity(CreateEntityType entityType) {
        final var locator = String.format(CREATE_ENTITY_LOCATOR, entityType.getName());
        return $x(locator);
    }

    public SelenideElement boardCard(final String name) {
        final var locator = String.format(BOARD_CARD_LOCATOR, name);
        return $x(locator);
    }
}
