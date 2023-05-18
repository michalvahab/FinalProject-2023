package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;


public class ProductsPage extends BasePage {

    private final Locator pageTitleElement = page.locator("[class=\"title\"]");
    private final Locator shoppingCartElement = page.locator("[class=\"shopping_cart_link\"]");
    private final Locator sortItemsDropdown = page.locator("select[data-test=\"product_sort_container\"]");

    private final List<Locator> items = page.locator("[class=\"inventory_item\"]").all();


    public ProductsPage(Page page) {
        super(page);
    }

    public void validateTitle(String expectedTitle) {
        this.checkElementText(pageTitleElement, expectedTitle);
    }

    public void sortItems(String sortedValue) {
        this.selectFromDropdown(sortItemsDropdown, sortedValue);
    }

    public void sortItems(int index) {
        this.selectFromDropdown(sortItemsDropdown, index);
    }

    public void chooseItem(String itemTitle) {
        for (Locator item : items) {
            String actualTitle = item.locator("[class=\"inventory_item_name\"]").textContent();
            if (actualTitle.equals(itemTitle)) {
                this.clickElement(item.locator("button"));
            }

        }
    }

    public void validateAddedItems(String numberOfItems) {
        this.checkElementText(shoppingCartElement, numberOfItems);
    }

    public void navigateCart() {
        shoppingCartElement.click();
    }
}