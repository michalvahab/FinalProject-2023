package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final Locator usernameElement = page.getByPlaceholder("Username");
    private final Locator passwordElement = page.locator("[data-test=\"password\"]");
    private final Locator loginButtonElement = page.getByText("Login");
    private final Locator errorMessageElement = page.locator("[data-test=\"error\"]");

    public LoginPage(Page page) {
        super(page);
    }

    public void fillLoginForm(String username, String password) {
        this.typeText(usernameElement, username);
        this.fillText(passwordElement, password);
        this.clickElement(loginButtonElement);
    }

    public void validateLoginErrorMessage(String expectedErrorMessage) {
        this.checkElementText(errorMessageElement, expectedErrorMessage);
    }
}
