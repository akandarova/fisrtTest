package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement genderMale = $("[value=Male]");
    private final SelenideElement userPhoneNumber = $("#userNumber");
    private final SelenideElement fieldState = $("#state");
    private final SelenideElement fieldCity = $("#city");
    private final SelenideElement submitButton = $("#submit");

    public RegistrationPage setFirstName(String name) {
        firstName.setValue(name);

        return this;
    }
    public RegistrationPage setLasttName(String name) {
        lastName.setValue(name);

        return this;
    }
    public RegistrationPage selectGender() {
        genderMale.click();

        return this;
    }
    public RegistrationPage setPhoneNumber(String phoneNumber) {
        userPhoneNumber.setValue(phoneNumber);

        return this;
    }
    public RegistrationPage selectState(String stateName) {
        fieldState.scrollTo().click();
        $(byText(stateName)).click();

        return this;
    }
    public RegistrationPage selectCity(String cityName) {
        fieldCity.scrollTo().click();
        $(byText(cityName)).click();

        return this;
    }
    public RegistrationResultPage submit(){
        submitButton.click();

        return new RegistrationResultPage();
    }

}
