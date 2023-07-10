package ru.levelp.at.taf.trello.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    public SelenideElement loginInButton = $x("//a[contains(@data-uuid, '_login')]");

    public SelenideElement emailTextField = $x("//*[@id='user']");
    public SelenideElement continueButton = $x("//*[@id='login']");

    public SelenideElement passwordTextField = $x("//*[@name='password']");
    public SelenideElement logInButton = $x("//button[@id='login-submit']");
}
