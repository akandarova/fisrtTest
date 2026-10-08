package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
       Configuration.holdBrowserOpen = true;
       Configuration.pageLoadTimeout = 50_000;
       open("https://ya.ru/");
       $("#text").setValue("bulgakov qa");
       $("[type=submit]").click();
       $(".DistributionButtonClose").click();
       $(byText("ivanbulgakovqa.ru")).click();

       sleep(3000);
       switchTo().window(1);
       $$(".t-menu__list li").last().click();
       $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();
       $(byText("Бегу оплачивать")).click();

      sleep(20000);
       switchTo().window(2);
      $("[data-at='H3']").shouldHave(text("₽ 47 000.00"));

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

       Configuration.holdBrowserOpen = true;
       Configuration.pageLoadTimeout = 50_000;
       open("https://demoqa.com/automation-practice-form");
       $("#firstName").setValue("Иван");
       $("#lastName").setValue("Иванченко");
       $("[value=Male]").click();
       $("#userNumber").setValue("7917123456");
       $("#state").scrollTo().click();
       $(byText("Uttar Pradesh")).click();
       $("#city").click();
       $(byText("Agra")).click();
       $("#submit").scrollTo().click();

       $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Иван" + " " + "Иванченко"));
       $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
       $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7917123456"));
       $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh" + " " + "Agra"));
    }

}
