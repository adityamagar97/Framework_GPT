package base;

import pages.LoginPage;
import pages.RegisterPage;
import utils.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;



import org.testng.annotations.AfterMethod;

public class BaseClass {

    public static  WebDriver driver;
  public   LoginPage lp ;
  public RegisterPage rp;
    @BeforeMethod
    public void setUp() {
  
    
    	    String browser = ConfigReader.get("browser");

    	    if ("chrome".equalsIgnoreCase(browser)) {
    	      //  System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // replace with actual path
    	        driver = new ChromeDriver();
    	    } else {
    	        throw new RuntimeException("Unsupported browser: " + browser);
    	    }

    	 
    	    lp = new LoginPage(driver);
    	    rp = new RegisterPage(driver);
    	}
    
        
      
    

    @AfterMethod
    public void tearDown() {
       
         
            driver.quit();
        
    }
}
