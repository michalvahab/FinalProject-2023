package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.SelectOption;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void clickElement(Locator element) {
        element.click();
        System.out.println("Clicking on " + element + "...");
    }

    protected void typeText(Locator element, String textToType) {
        element.clear();
        element.type(textToType, new Locator.TypeOptions().setDelay(50));
    }

    protected void fillText(Locator element, String textToType) {
        element.fill(textToType);
    }

    public void assertThatPageUrl(String expectedUrl) {
        assertThat(page).hasURL(expectedUrl);
    }

    public void assertEqualsPageUrl(String expectedUrl) {
        Assert.assertEquals(page.url(), expectedUrl);
    }

    public void checkElementText(Locator element, String expectedText) {
        assertThat(element).hasText(expectedText, new LocatorAssertions.HasTextOptions().setTimeout(10000));
    }

    protected void selectFromDropdown(Locator element, String value) {
        element.selectOption(value);
        page.waitForTimeout(3000);
    }

    protected void selectFromDropdown(Locator element, int index) {
        element.selectOption(new SelectOption().setIndex(index));
        page.waitForTimeout(3000);
    }
}