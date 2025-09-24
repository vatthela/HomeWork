package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By inventoryItemName = By.xpath("//*[@class='inventory_item_name']");
    By checkoutButton = By.xpath("//button[@id='checkout']");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getInventoryItemName() {
        return driver.findElement(inventoryItemName).getText();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}
