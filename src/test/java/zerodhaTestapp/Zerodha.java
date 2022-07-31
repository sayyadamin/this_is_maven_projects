package zerodhaTestapp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import loginPomClasses.LoginPom;
import loginPomClasses.PinPom;



public class Zerodha {

	WebDriver driver;
	LoginPom log;
	PinPom enterPin;

	

	@BeforeClass
	public void openUrl() throws InterruptedException {
		Reporter.log("PAGE TITLE",true);
		
					
		WebDriverManager.chromedriver().setup();
		

		ChromeOptions opt=new ChromeOptions();
		
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		
	
		driver = new ChromeDriver(opt);
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Thread.sleep(2000);
		String expTitle = "Kite - Zerodha's fast and elegant flagship trading platform";

		Assert.assertEquals(actTitle, expTitle);
		
	}

	@Test(priority=0)
	public void login() throws InterruptedException {
		Reporter.log("LOGIN PAGE",true);
		Thread.sleep(2000);
		log = new LoginPom(driver);
		log.userId("DAA677");
		log.validPass("Velocity@123");
		log.logIn();
      Assert.assertEquals("DAA677", "DAA677","VALID USER ID");
      Reporter.log("VALID USER ID",true);
      Assert.assertNotEquals("DAA677", "DAA678","INVALID USER ID");
      Reporter.log("INVALID USER ID",true);
      
      Assert.assertEquals("Velocity@123", "Velocity@123","VALID USER PASSWORD");
      Reporter.log("VALID USER PASSWORD",true);
      Assert.assertNotEquals("Velocity@123","Velocity@1234" ,"INVALID USER PASSWORD");
      Reporter.log("INALID USER PASSWORD",true);
	}
	@Test(priority=1)
	public void authorization() throws InterruptedException {
		Thread.sleep(2000);
		Reporter.log("Authorization ",true);
		enterPin = new PinPom(driver);
		enterPin.enterPin("866918");
	   	enterPin.contineu();
	   	Assert.assertEquals("866918", "866918");
	   	Reporter.log("VALID PIN");
	   	Assert.assertNotEquals("866918", "866920");
		Reporter.log("INVALID PIN");
		Reporter.log("CONTINEU BTN WORKING");
		
		
  
	}
	
	
	

	@AfterClass
	public void Close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();

	}

}
