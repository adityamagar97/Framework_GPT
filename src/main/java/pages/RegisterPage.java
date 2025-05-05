package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	

	
	@FindBy (xpath = "//*[@id=\"title\"]") WebElement title;
	@FindBy (xpath = "//*[@id=\"first_name\"]") WebElement name;
	@FindBy (xpath = "//*[@id=\"last_name\"]") WebElement lname;
	@FindBy (xpath = "//*[@id=\"email\"]") WebElement email;
	@FindBy (xpath = "//*[@id=\"phone\"]") WebElement phoen;
	@FindBy (xpath = "//*[@id=\"mobile\"]") WebElement mobile;
	@FindBy (xpath = "//*[@id=\"password\"]") WebElement password;
	@FindBy (xpath = "//*[@id=\"passconf\"]") WebElement confirmP;
	@FindBy (xpath = "//*[@id=\"terms\"]") WebElement clcik;
	@FindBy (xpath = "//*[@id=\"register_submit\"]") WebElement register;
	
	
	WebDriver driver ;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	public void tit(String ti) {
		
		title.sendKeys(ti);
	}
public void nam(String na) {
		
		name.sendKeys(na);
	}
public void sur(String su) {
	
	lname.sendKeys(su);
}
public void ema(String em) {
	
	email.sendKeys(em);
}
public void pho(String ph) {
	
	phoen.sendKeys(ph);
}
public void mob(String mo) {
	
	mobile.sendKeys(mo);
}
public void pas(String pa) {
	
	password.sendKeys(pa);
}
public void cop(String co) {
	
	confirmP.sendKeys(co);
}
public void tick() {
	
	clcik.click();
}
public void regis() {
	
	register.click();
}
public void condition(String conditio) {
	
}
	

}
