package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmCheckoutPage {
    WebDriver driver;
    By inventoryItemNameLabel = By.xpath("//*[@class='inventory_item_name']");
    By lastNameInput = By.xpath("//input[@id='last-name']");
    By postCodeInput = By.xpath("//input[@id='postal-code']");
    By finishButton = By.xpath("//*[@id='finish']");

    public ConfirmCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getInventoryItemName() {
        return driver.findElement(inventoryItemNameLabel).getText();
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}





