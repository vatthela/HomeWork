

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.CartPage;
import pageObject.CheckoutPage;
import pageObject.ConfirmCheckoutPage;
import pageObject.LoginPage;
import pageObject.ProductPage;

public class Test {
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
        String actualCartProductName = cartPage.getInventoryItemName();
        Assert.assertEquals(actualCartProductName, productName);
        cartPage.clickCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputFirstname(firstName);
        checkoutPage.inputLastname(lastName);
        checkoutPage.inputPostcode(postCode);
        checkoutPage.clickContinueButton();
        ConfirmCheckoutPage confirmCheckoutPage = new ConfirmCheckoutPage(driver);
        String actualProductName = confirmCheckoutPage.getInventoryItemName();
        Assert.assertEquals(actualProductName, productName);
        confirmCheckoutPage.clickFinishButton();
        driver.quit();
    }   
}
