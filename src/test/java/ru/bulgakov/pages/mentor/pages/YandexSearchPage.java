package ru.bulgakov.pages.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {
    private final SelenideElement searchInput = $("#text");
    private final SelenideElement submitButton = $("[type=submit]");

    public YandexSearchPage setSearchQuery(String query) {
        searchInput.setValue(query);
        return this;
    }
    public YandexSearchResultPage submit() {
        submitButton.click();
        return new YandexSearchResultPage();
    }
    public YandexSearchResultPage search(String query) {
        return setSearchQuery(query).submit();
    }
}
