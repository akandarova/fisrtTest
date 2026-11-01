package ru.bulgakov.pages.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsItemPage {

    private final ElementsCollection attributesOfItem = $$("dl dd ul");
    private final String PROCESSOR_SELECTOR = "li input";
    private final SelenideElement inputQuantity = $(".qty-input");
    private final SelenideElement addItemToCartButton = $("input.add-to-cart-button");
    private final SelenideElement barNotification = $("div.bar-notification.success");
    private final SelenideElement itemQuantityInCart = $("span.cart-qty");
    public final SelenideElement cartHeaderLink = $("a.ico-cart");

    private static final SelenideElement itemName = $("[itemprop=name]");
    private static final SelenideElement itemPrice = $("[itemprop=price]");

    public WsItemPage selectProcessor(int index) {
        attributesOfItem.get(0).$$(PROCESSOR_SELECTOR).get(index).click();
        return this;
    }
    public String getItemPriceWithProcessor(int index) {
        float base = Float.parseFloat(getItemPrice().replaceAll("[^0-9.]", ""));
        float extra = switch (index) {
            case 1 -> 15.00f;
            case 2 -> 100.00f;
            default -> 0f;
        };
        return String.format(java.util.Locale.US, "%.2f", base + extra);
    }
    public static String getItemName() {
        return itemName.getText();
    }

    public static String getItemPrice() {
        return itemPrice.getText();
    }

    public WsItemPage inputItemQuantity(String itemQuantity) {
        inputQuantity.setValue(itemQuantity);
        return this;
    }
    public WsItemPage addItemToCart() {
        addItemToCartButton.click();
        return this;
    }
    public WsItemPage checkBarNotification() {
        barNotification.shouldBe(visible);
        return this;
    }
    public WsItemPage checkQuantityItemInCart(String itemQuantity) {
        itemQuantityInCart.shouldHave(text("(" + itemQuantity + ")"));
        return this;
    }
    public WsCartPage checkCart() {
        cartHeaderLink.click();
        return new WsCartPage();
    }
}
