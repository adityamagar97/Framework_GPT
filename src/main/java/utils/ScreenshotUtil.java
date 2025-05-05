package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

//    public static String captureScreenshot(WebDriver driver) {
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String path = "screenshots/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
//        try {
//            FileUtils.copyFile(src, new File(path));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return path;

        
        public static String captureScreenshot(WebDriver driver) {
            // Create screenshot folder if it doesn't exist
            new File("screenshots").mkdirs();

            // File name with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String relativePath = "screenshots/" + timestamp + ".png";
            String absolutePath = System.getProperty("user.dir") + File.separator + relativePath;

            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File(absolutePath));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return absolutePath; // Return full path for ExtentReport
}
}
