package ru.bulgakov.pages.webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WsCartPage {
    private final SelenideElement itemNameInCart = $("a.product-name");
    String itemQuantityInCart = $("input.qty-input").getAttribute("value");
    private final SelenideElement priceItemInCart = $("span.product-subtotal");


    public WsCartPage checkItemNameInCart(String itemName) {
        itemNameInCart.shouldHave(text(itemName));
        return this;
    }
    public WsCartPage checkItemQuantityInCart(String itemQuantity) {
        assertEquals(itemQuantity, itemQuantityInCart);
        return this;
    }
    public WsCartPage checkItemPriceInCart(String itemPrice, String itemQuantity) {
        priceItemInCart.shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        System.out.println("1");
        return this;
    }
}
