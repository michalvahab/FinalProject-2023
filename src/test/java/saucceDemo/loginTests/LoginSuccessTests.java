package saucceDemo.loginTests;


import org.testng.annotations.Test;
import pages.LoginPage;
import saucceDemo.BaseTest;

public class LoginSuccessTests extends BaseTest {

    @Test
    public void test_01_standardUserLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("standard_user", "secret_sauce");

    }

    @Test
    public void test_02_problemUserLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("problem_user", "secret_sauce");

    }

    @Test
    public void test_03_performance_glitchUserLogin() {

        page.navigate("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(page);
        loginPage.assertThatPageUrl("https://www.saucedemo.com/");
        loginPage.fillLoginForm("performance_glitch_user", "secret_sauce");

    }


}