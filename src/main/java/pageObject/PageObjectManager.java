package pageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LoginPage loginPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public WebDriver driver;
    public CheckoutPage checkoutPage;
    public ConfirmCheckoutPage confirmCheckoutPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public ProductPage getProductPage() {
        productPage = new ProductPage(driver);
        return productPage;
    }

    public CartPage getCartPage() {
        cartPage = new CartPage(driver);
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
    public ConfirmCheckoutPage getConfirmCheckoutPage() {
        confirmCheckoutPage = new ConfirmCheckoutPage(driver);
        return confirmCheckoutPage;
    }

}
