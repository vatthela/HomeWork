package ultis;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;


public class Screenshot {
    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        if (driver == null) {
            System.err.println("WebDriver is null. Cannot take screenshot.");
            return;
        }
        
        try {
            // Chụp ảnh dưới dạng file
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Tạo thư mục để lưu ảnh (nếu chưa có)
            File destinationFolder = new File("screenshots");
            if (!destinationFolder.exists()) {
                destinationFolder.mkdirs();
            }
            
            // Đặt tên file và lưu ảnh vào thư mục
            File destFile = new File(destinationFolder.getAbsolutePath() + File.separator + screenshotName + ".png");
            FileHandler.copy(sourceFile, destFile);
            
            System.out.println(destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Lỗi khi chụp ảnh màn hình: " + e.getMessage());
        }
    }
}
