package bstack.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement psw;
	
	@FindBy(id="login-btn")
	private WebElement login;
	
	@FindBy(id="logout")
	private WebElement logout;
	
	public void userName(String usrname) {
		new Actions(driver).moveToElement(userName).click().sendKeys(usrname).sendKeys(Keys.ENTER).perform();
	}
	
	public void psw(String password) {
		new Actions(driver).moveToElement(psw).click().sendKeys(password).sendKeys(Keys.ENTER).perform();
	}
	
	public void login() {
		login.click(); 
	}
	
	public void userLogout() {
		logout.click();
	}
}
