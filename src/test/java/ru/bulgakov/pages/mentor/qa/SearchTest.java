package ru.bulgakov.pages.mentor.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.mentor.pages.PaymentPage;
import ru.bulgakov.pages.mentor.pages.RegistrationPage;
import ru.bulgakov.pages.mentor.pages.WelcomePage;
import ru.bulgakov.pages.mentor.pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 50_000;
        Configuration.timeout = 10_000;
    }

   @Test
   void mentoringPriceShouldBe47000Test(){

       open("https://ya.ru/", YandexSearchPage.class)
               .search("bulgakov qa")
               .openLink("ivanbulgakovqa.ru")
               .switchToWindow(1, WelcomePage.class)
               .openCostSection()
               .clickButtonWantToQa()
               .clickButtonToPay()
               .switchToWindow(2, PaymentPage.class)
               .checkPriceAmount("₽ 47 000.00");
    }
    @Test
    void registrationResultShouldShowEnteredDataTest(){

       open("https://demoqa.com/automation-practice-form", RegistrationPage.class)
               .setFirstName("Иван")
               .setLastName("Иванченко")
               .selectGender("Male")
               .setPhoneNumber("7917123456")
               .selectState("Uttar Pradesh")
               .selectCity("Agra")
               .submit()
               .checkFullName("Иван", "Иванченко")
               .checkGender("Male")
               .checkPhoneNumber("7917123456")
               .checkStateAndCity("Uttar Pradesh", "Agra");
    }

}
