package saucceDemo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setupTest() {
        System.out.println("Opening browser...");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
        );

        page = browser.newPage();
        page.setViewportSize(1900, 1000);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing browser...");
        page.waitForTimeout(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
