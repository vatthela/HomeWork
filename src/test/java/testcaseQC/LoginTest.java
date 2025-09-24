package testcaseQC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.ProductPage;

public class LoginTest {
    //public PageObjectManager pageObjectManager;
    private WebDriver driver;
    @BeforeMethod
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
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
            {"problem_user", "secret_sauce"}, //Testcase 1
            {"", "secret_sauce"}, //Testcase 2
            {"problem_user", ""}, //Testcase 3
            {"incorrect_username", "secret_sauce"}, //Testcase 4
            {"problem_user", "incorrect_password"}, //Testcase 5
        };
    }


    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.verifyProductPageIsPageLoaded(), "Login failed");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
