package ru.bulgakov.pages.webshop;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    @Test
    void registrationTest(){
        Configuration.pageLoadTimeout = 50_000;
        
        open("https://demowebshop.tricentis.com/");
        $(".ico-register").click();


    }
}
