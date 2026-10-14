package ru.bulgakov.pages.mentor.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class WelcomePage extends BasePage {
    private final ElementsCollection costSection = $$(".t-menu__list li");
    private final SelenideElement buttonWantToQa = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");
    private final SelenideElement buttonToPay = $(byText("Бегу оплачивать"));

    public WelcomePage sleepAndSwitchToWindow() {
        switchTo().window(1);
        return this;
    }

    public WelcomePage openCostSection() {
        costSection.last().click();
        return this;
    }

    public WelcomePage clickButtonWantToQa() {
        buttonWantToQa.click();
        return this;
    }

    public PaymentPage clickButtonToPay() {
        buttonToPay.click();
        return new PaymentPage();
    }
}


