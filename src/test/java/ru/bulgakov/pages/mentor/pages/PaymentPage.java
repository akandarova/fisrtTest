package ru.bulgakov.pages.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class PaymentPage extends BasePage {

    private final SelenideElement costMenuLink = $("a.t-menu__link-item[href='#cost']");
    private final SelenideElement buttonWantToQa = $(byText("Хочу вкатиться в QA"));
    private final SelenideElement price = $("[class*='price']");

    public PaymentPage sleepAndSwitchToWindowPayment() {
        switchTo().window(2);
        return this;
    }

    public PaymentPage checkPriceAmount(String priceOfStudy) {
        price.shouldHave(text(priceOfStudy));
        return this;
    }
}
