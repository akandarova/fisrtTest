package ru.bulgakov.pages.webshop.tests;

import com.codeborne.selenide.Configuration;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.webshop.pages.WsRegistrationPage;
import ru.bulgakov.pages.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.pages.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.pages.webshop.config.Config.WEB_SHOP_URL;

public class LoginTest {
    public static final Faker faker = new Faker();
    private String email;
    private String password;

    @BeforeEach
    void beforeAll(){
        Configuration.pageLoadTimeout = 50_000;

        password = faker.harryPotter().character() + faker.number().positive();
        email = faker.internet().emailAddress();

        open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                .register(faker.name().firstName(),
                        faker.name().lastName(),
                        email,
                        password)
        .checkUserLoggedIn(email);

        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    void successLoginTest(){
        open(WEB_SHOP_URL, WsWelcomePage.class)
        .openLogin()
        .checkLoginPageOpened()
        .enterEmail(email)
        .enterPassword(password)
        .checkRememberMe()
        .submitLogin()
        .checkUserLoggedIn(email);

        System.out.println("1");
    }
}
