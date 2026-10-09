package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultPage {
    private final SelenideElement fullNameResult = $(".table-responsive").$(byText("Student Name")).parent();
    private final SelenideElement userGenderResult = $(".table-responsive").$(byText("Gender")).parent();
    private final SelenideElement userPhoneNumberResult = $(".table-responsive").$(byText("Mobile")).parent();
    private final SelenideElement userStateCityResult = $(".table-responsive").$(byText("State and City")).parent();


    public RegistrationResultPage reviewName(String name) {
        fullNameResult.shouldHave(text("Иван" + " " + "Иванченко"));

        return this;
    }
    public RegistrationResultPage reviewGender(String gender) {
    userGenderResult.shouldHave(text(gender));

        return this;
    }
    public RegistrationResultPage reviewPhoneNumber(String phoneNumber) {
        userPhoneNumberResult.shouldHave(text(phoneNumber));

        return this;
    }
    public RegistrationResultPage reviewStateCity(String stateCity) {
        userStateCityResult.shouldHave(text(stateCity));

        return this;
    }



}
