package ru.bulgakov.pages.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexSearchResultPage extends BasePage {
    private static final Duration BANNER_TIMEOUT = Duration.ofSeconds(3);
    private final SelenideElement distributionBannerClose = $(".DistributionButtonClose");
    private final SelenideElement closeWindow = $(".DistributionButtonClose");

    public YandexSearchResultPage closeDistributionBannerIfAppeared() {
        if (distributionBannerClose.is(visible, BANNER_TIMEOUT)) {
            distributionBannerClose.click();
        }
        return this;
    }

    public YandexSearchResultPage closeDefaultBrowserSelectWindow() {
        closeWindow.click();
        return this;
    }

    public YandexSearchResultPage openLink(String websiteName) {
        $$("a[href*='" + websiteName + "']").filterBy(visible)
                .first()
                .click();
        return this;
    }
}

