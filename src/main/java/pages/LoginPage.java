package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class LoginPage {

    WebDriver driver;
    Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    WebElement username;

    @FindBy(id = "login-password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div[5]/div/button")
    WebElement loginBtn;

    public void login(String user, String pass,String condition) {
      
        username.sendKeys(user);
        password.sendKeys(pass);
       loginBtn.click();
    
    }
    
}
