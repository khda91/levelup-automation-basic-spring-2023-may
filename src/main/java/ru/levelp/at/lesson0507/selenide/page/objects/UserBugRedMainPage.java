package ru.levelp.at.lesson0507.selenide.page.objects;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class UserBugRedMainPage {

    public final SelenideElement userDropdown;

    public UserBugRedMainPage() {
        userDropdown = $x("//li[@id='fat-menu']/a[@class='dropdown-toggle']");
    }
}
