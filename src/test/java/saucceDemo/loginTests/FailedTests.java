package saucceDemo.loginTests;

import org.testng.annotations.Test;
import pages.LoginPage;
import saucceDemo.BaseTest;

public class FailedTests extends BaseTest {

    @Test
    public void test_01_lockedUserLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("locked_out_user", "secret_sauce");
        loginPage.validateLoginErrorMessage("Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void test_02_emptyUsernameLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("", "secret_sauce");
        loginPage.validateLoginErrorMessage("Epic sadface: Username is required");

    }

    @Test
    public void test_03_emptyUsernameAndEmptyPasswordLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("", "");
        loginPage.validateLoginErrorMessage("Epic sadface: Username is required");
    }

    @Test
    public void test_04_emptyPasswordLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "");
        loginPage.validateLoginErrorMessage("Epic sadface: Password is required");
    }

    @Test
    public void test_05_wrongPasswordLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "1234");
        loginPage.validateLoginErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }
}


