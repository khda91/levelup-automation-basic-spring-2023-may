package ru.levelp.at.taf.trello.pages;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class BoardPage {

    public SelenideElement title = $x("//*[@data-testid='board-name-display']");

    public SelenideElement addAListButton = $x("//a[contains(@class, 'open-add-list')]");
    public SelenideElement addListItemTextBox = $x("//*[@class='list-name-input']");

    public SelenideElement addListButton = $x("//input[@value='Add list']");

    public ElementsCollection listItemCards = $$x("//*[contains(@class, 'list-header-target')]");
}
