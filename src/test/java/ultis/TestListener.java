package ultis;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case fail: " + result.getName());
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
        
        if (driver != null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = result.getName() + "_" + timestamp;
            Screenshot.takeScreenshot(driver, screenshotName);
        } else {
            System.err.println("WebDriver instance not found in TestContext. Cannot take screenshot.");
        }
    }
}
