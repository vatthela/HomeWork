package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By usernameInput = By.xpath("//input[@id='user-name']");
    By passwordInput = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//*[@id='login-button']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }
    public void inputPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
