package testcaseQC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pageObject.CartPage;
import pageObject.LoginPage;
import pageObject.ProductPage;

public class DemoTest {
    //public PageObjectManager pageObjectManager;

    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String productName = "Sauce Labs Backpack";
        String username = "standard_user";
        String password = "secret_sauce";
        String firstName = "Bui Tung";
        String lastName = "Lam";
        String postCode = "100000";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart(productName);
        productPage.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        pageObject.CheckoutPage

    }
}
