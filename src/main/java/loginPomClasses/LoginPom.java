package loginPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='userid']") private WebElement uId;
	@FindBy(xpath = "//input[@id='password']") private WebElement psw;
	@FindBy(xpath = "//button[@type='submit']")private WebElement btn;

	public  LoginPom(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void userId(String user) {

		uId.sendKeys(user);

	}

	public void validPass(String password) {

		psw.sendKeys(password);

	}

	public void logIn() {

		btn.click();

	}

}
