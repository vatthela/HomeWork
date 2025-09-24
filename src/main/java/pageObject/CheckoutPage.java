package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;
    By firstNameInput = By.xpath("//input[@id='first-name']");
    By lastNameInput = By.xpath("//input[@id='last-name']");
    By postCodeInput = By.xpath("//input[@id='postal-code']");
    By continueButton = By.xpath("//button[@id='continue']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstname(String firstname) {
        driver.findElement(firstNameInput).sendKeys(firstname);

    }

    public void inputLastname(String lastname) {
        driver.findElement(lastNameInput).sendKeys(lastname);
    }

    public void inputPostcode(String postcode) {
        driver.findElement(postCodeInput).sendKeys(postcode);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}





