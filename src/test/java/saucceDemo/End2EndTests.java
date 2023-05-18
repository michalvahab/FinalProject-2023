package saucceDemo;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

public class End2EndTests extends BaseTest {


    @Test
    public void test_01_buyItemsTest() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(page);
        productsPage.assertThatPageUrl("https://www.saucedemo.com/inventory.html");
        productsPage.validateTitle("Products");
        productsPage.sortItems("Price (high to low)");
        productsPage.sortItems(1);
        productsPage.chooseItem("Sauce Labs Backpack");
        productsPage.validateAddedItems("1");
        productsPage.navigateCart();

        YourCartPage yourCart = new YourCartPage(page);
        yourCart.assertThatPageUrl("https://www.saucedemo.com/cart.html");
        yourCart.validateTitle("Your Cart");
        yourCart.clickButton("#checkout");
        yourCart.assertThatPageUrl("https://www.saucedemo.com/checkout-step-one.html");
        yourCart.validateTitle("Checkout: Your Information");
        yourCart.fillCartForm("Michal", "Arusi", "123");
        yourCart.assertThatPageUrl("https://www.saucedemo.com/checkout-step-two.html");
        yourCart.validateTitle("Checkout: Overview");
        yourCart.clickButton("#finish");
        yourCart.assertThatPageUrl("https://www.saucedemo.com/checkout-complete.html");
        yourCart.validateTitle("Checkout: Complete!");
        yourCart.validateOrderSuccessMessage("Thank you for your order!");
        page.waitForTimeout(3000);
        yourCart.clickButton("#back-to-products");
    }


}
