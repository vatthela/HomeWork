package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    By inventoryItemName = By.xpath(".//*[@class='inventory_item_name ']");
    By title = By.className("title");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyProduct (String productName){
        String product = driver.findElement(inventoryItemName).getText();
        return product.equalsIgnoreCase(productName);
    }

    public void addToCart(String productName){
        By addToCartButton = By.xpath("//div[contains(text(), '"+productName+"')]/ancestor::div[@class='inventory_item']//button[text()='Add to cart']");
        driver.findElement(addToCartButton).click();

    }
    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public boolean verifyProductPageIsPageLoaded() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        if (driver.findElement(title).getText().equalsIgnoreCase("Products")) {
            return true;
        } else {
            return false;
        }
    }
}
