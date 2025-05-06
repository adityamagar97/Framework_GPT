package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import utils.ConfigReader;
import utils.ExcelUtil;

public class RegisterTest extends BaseClass {
	
	@Test(dataProvider = "RegisterData", dataProviderClass = ExcelUtil.class)
	void validateRegis(String ti,String na,String su,String em,String ph,String mo,String pa, String co,String conditio) {
		
		 driver.get(ConfigReader.get("register_url"));
		rp.tit(ti);
		rp.nam(na);
		rp.sur(su);
		rp.ema(em);
		rp.pho(ph);
		rp.mob(mo);
rp.pas(pa);
rp.cop(co);
rp.tick();
rp.regis();

if(conditio.equals("valid")) {
	
	Assert.assertEquals(driver.getTitle(),"");
	
}
else if(conditio.equals("invalid")) {
	

	String acct = driver.findElement(By.xpath("//*[@id=\"phone-error\"]")).getText();

		
	Assert.assertEquals( acct, "Please enter a valid telepsshone number.");
	
}
else if(conditio.equals("blank")) {
	

	String actt = driver.findElement(By.xpath("//*[@id=\'email-error\']")).getText();

		
	Assert.assertEquals( actt, "Please enter a valid email address.");
	
}
else if(conditio.equals("LongEmail")) {
	
	
	String act = driver.findElement(By.xpath("//*[@id=\'email-error\']")).getText();

		
	Assert.assertEquals( act, "Please enter a valid email address.");
	
}
		
	}
	
	
	

}
