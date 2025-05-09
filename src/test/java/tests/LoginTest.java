package tests;

import base.BaseClass;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelUtil;

import org.testng.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import utils.ConfigReader;

  

    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.AfterMethod;
    import utils.ConfigReader;

    public class LoginTest extends BaseClass {
        
   

        @Test (dataProvider = "loginData", dataProviderClass  =ExcelUtil.class )
        public void loginFailureTest(String user, String pass,String condition) {
        	
     	   String url = ConfigReader.get("url");
      	    driver.get(url);
        	
        	lp.login(user,pass,condition);
        	
        
        	
       if(condition.equals("invalid"))
       {
        	String actual = driver.findElement(By.xpath("//*[@id=\"login-username-error\"]")).getText();
        	Assert.assertEquals(actual ,"Please enter a avalid email address.");
        	System.out.println("making it fail");
        	//Login
       }
       else if(condition.equals("valid")) {
    	   String actual = driver.getTitle();
       	Assert.assertEquals(actual ,"");
       	System.out.println("it will pass");
       	//Login
       }
    	   
        else if(condition.equals("blank")) {
     	   String actual = driver.findElement(By.xpath("//*[@id=\"login-username-error\"]")).getText();
        	Assert.assertEquals(actual ,"Please enter a vsalid email address.");
        	//Login
        	System.out.println("making it fail");
       }
        
     
    	

        
     

        }
    
}
