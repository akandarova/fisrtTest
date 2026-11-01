package ru.bulgakov.pages.webshop.tests;

import com.codeborne.selenide.Configuration;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.webshop.pages.WsCartPage;
import ru.bulgakov.pages.webshop.pages.WsItemPage;
import ru.bulgakov.pages.webshop.pages.WsLoginPage;
import ru.bulgakov.pages.webshop.steps.AuthSteps;

import static com.codeborne.selenide.Selenide.open;
import static ru.bulgakov.pages.webshop.config.Config.WEB_SHOP_URL;

public class CartTest {

    private static final Faker faker = new Faker();
    private static AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 50_000;

        authSteps.registerNewUser();
    }
        @Test
        void addItemToCartTest() {
            String itemQuantity = "2";

            WsItemPage itemPage = open(WEB_SHOP_URL, WsLoginPage.class)
            .openListOfComputers()
            .chooseDesctopsComputers("Desktops")
            .chooseItem();

            String itemName  = itemPage.getItemName();

            itemPage.selectProcessor(2);
            String itemPrice = itemPage.getItemPriceWithProcessor(2);

            WsCartPage cartPage = itemPage

            .inputItemQuantity(itemQuantity)
            .addItemToCart()
            .checkBarNotification()
            .checkQuantityItemInCart(itemQuantity)
            .checkCart();

            cartPage

            .checkItemNameInCart(itemName)
            .checkItemQuantityInCart(itemQuantity)
            .checkItemPriceInCart(itemPrice, itemQuantity);
        }
    }

