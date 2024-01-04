package bstack.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstNameInput")
	public WebElement firstName;

	@FindBy(id = "lastNameInput")
	public WebElement lastName;

	@FindBy(id = "addressLine1Input")
	public WebElement address;

	@FindBy(id = "provinceInput")
	public WebElement state;

	@FindBy(id = "postCodeInput")
	public WebElement postalCode;
	
	@FindBy(id="checkout-shipping-continue")
	public WebElement submit;
	
	public void firstname(String str) {
		firstName.sendKeys(str);
	}
	
	public void lastname(String str) {
		lastName.sendKeys(str);
	}
	
	public void addresS(String str) {
		address.sendKeys(str);
	}
	
	public void stateName(String str) {
		state.sendKeys(str);
	}
	
	
	public void postCode(String str) {
		postalCode.sendKeys(str);
	}
	
	public void ckSubmit() {
		submit.click();
	}
	
}
