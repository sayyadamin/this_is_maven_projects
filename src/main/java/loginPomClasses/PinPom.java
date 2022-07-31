package loginPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinPom {

	@FindBy(xpath = "//input[@type=\'password\'] ")
	private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement contiBtn;

	public PinPom(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void enterPin(String validPin) {

		pin.sendKeys(validPin);
	}

	public void contineu() {

		contiBtn.click();
		boolean btn = contiBtn.isEnabled();
		System.out.println(btn);
	}

}
