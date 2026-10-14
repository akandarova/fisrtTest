package ru.bulgakov.pages.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {

    private final SelenideElement price = $("[data-at='H3']");

    public PaymentPage sleepAndSwitchToWindowPayment() {
        sleep(20000);
        switchTo().window(2);

        return this;
    }

    public PaymentPage review(String priceOfStudy) {
        price.shouldHave(text(priceOfStudy));

        return this;

    }
}
