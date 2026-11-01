package ru.bulgakov.pages.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WsWelcomePage {
    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement loginButton = $("a.ico-login");


    public WsRegistrationPage openRegistration(){
        registerButton.click();
        return new WsRegistrationPage();
    }
    public WsLoginPage openLogin (){
        loginButton.click();
        return new WsLoginPage();
    }
}
