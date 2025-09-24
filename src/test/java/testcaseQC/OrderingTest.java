package testcaseQC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.CheckoutPage;
import pageObject.ConfirmCheckoutPage;
import pageObject.LoginPage;
import pageObject.ProductPage;

public class OrderingTest {
    //public PageObjectManager pageObjectManager;
    private WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser, ITestContext context) {
            switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        context.setAttribute("WebDriver", driver);
    }
    @Test
    public void testOrdering() {
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
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
