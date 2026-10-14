package ru.bulgakov.pages.mentor.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.mentor.pages.RegistrationPage;
import ru.bulgakov.pages.mentor.pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

   @Test
    void mentoringPriceShouldBe47000Test(){
/*
* Тест-кейс на процерку цена обучения равна 47000
* 1. Открыть поисковик (яндекс)
* 2. Ввести данные сайта (bulgakov qa)
* 3. Нажать нопку поиск
* 4. В поисковой выдаче найти нужный сайт и кликнуть на него
* 5. Нажать на кнопку "Стоимость"
* 6. Нажать на кнопку "Вкатиться в qa"
* 7. Нажать на кнопку "Бегу оплачивать"
* ...
* 10. Проверить, что к оплате 47000
 */
       Configuration.pageLoadTimeout = 50_000;

       open("https://ya.ru/", YandexSearchPage.class)
               .search("bulgakov qa")
               .submit()
               .closeDefaultBrowserSelectWindow()
               .openLink("ivanbulgakovqa.ru")
               .sleepAndSwitchToWindow()
               .selectLastMenuList()
               .clickButtonWantToQa()
               .clickButtonToPay()
               .sleepAndSwitchToWindowPayment()
               .review("₽ 47 000.00");

    }

    @Test
   void PracticeFormTest(){
       /*
        * Тест-кейс на проверку регистрации
        * 1. Открыть страницу регистрации
        * 2. заполнить firstName,
        * 3. заполнитьlastName
        * 4. выбрать пол
        * 5. указать номер телефона
        * 6. Выбрать штат
        * 7. Выбрать город
        * 8. Нажать кнопку Submit
        * 9. Проверить правильность заполнения
        * ...
        */

       Configuration.pageLoadTimeout = 50_000;
       open("https://demoqa.com/automation-practice-form", RegistrationPage.class)
               .setFirstName("Иван")
               .setLasttName("Иванченко")
               .selectGender()
               .setPhoneNumber("7917123456")
               .selectState("Uttar Pradesh")
               .selectCity("Agra")
               .submit()
               .checkFullName("Иван", "Иванченко")
               .reviewGender("Male")
               .reviewPhoneNumber("7917123456")
               .reviewStateCity("Uttar Pradesh", "Agra");


    }

}
