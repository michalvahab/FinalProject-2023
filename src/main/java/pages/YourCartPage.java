package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class YourCartPage extends BasePage {

    private final Locator pageTitleElement = page.locator("[class=\"title\"]");

    private final Locator firstNameElement = page.locator("#first-name");
    private final Locator lastNameElement = page.locator("#last-name");

    private final Locator zipElement = page.locator("#postal-code");
    private final Locator continueButtonElement = page.locator("#continue");

    private final Locator successMessageElement = page.locator("[class=\"complete-header\"]");

    public YourCartPage(Page page) {
        super(page);
    }

    public void validateTitle(String expectedTitle) {
        this.checkElementText(pageTitleElement, expectedTitle);
    }

    public void clickButton(String selector) {
        page.locator(selector).click();
    }

    public void fillCartForm(String firstName, String lastName, String zip) {
        this.typeText(firstNameElement, firstName);
        this.fillText(lastNameElement, lastName);
        this.fillText(zipElement, zip);
        this.clickElement(continueButtonElement);
    }

    public void validateOrderSuccessMessage(String expectedSuccessMessage) {
        this.checkElementText(successMessageElement, expectedSuccessMessage);
    }
}
