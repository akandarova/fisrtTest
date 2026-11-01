package ru.bulgakov.pages.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsLoginPage {
    private final SelenideElement loginPageTitle = $("div.page-title");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberMeCheckBox = $("input#RememberMe");
    private final SelenideElement loginButton = $("input.login-button");
    private final ElementsCollection listOfComputers = $$("ul.top-menu li a");
    private final ElementsCollection listOfItems = $$("div.product-grid div");

    public WsLoginPage checkLoginPageOpened() {
        loginPageTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public WsLoginPage checkRememberMe() {
        rememberMeCheckBox.click();
        return this;
    }

    public WsRegistrationPage submitLogin() {
        loginButton.click();
        return new WsRegistrationPage();
    }

    public WsLoginPage openListOfComputers() {
        listOfComputers.get(1).hover();
        return this;
    }

    public WsLoginPage chooseDesctopsComputers(String nameOfComputers) {
        $(byText(nameOfComputers)).click();
        return this;
    }

    public WsItemPage chooseItem() {
        listOfItems.get(0).click();
        return new WsItemPage();
    }
}


