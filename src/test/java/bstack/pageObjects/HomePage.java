package bstack.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;
	int cnt=0;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="offers")
	private WebElement offers;
	
	@FindBy(id="orders")
	public WebElement orders;
	
	@FindBy(id="favourites")
	public WebElement favourites;
	
	@FindBy(xpath="//span[@class=\"bag bag--float-cart-closed\"]")
	public WebElement bag;
	
	@FindBy(id="signin")
	public WebElement signIn;
	 
	@FindBy(xpath="//select")
	public WebElement orderBy;
	
	@FindBy(xpath="//div[@class=\"filters-available-size\"]//input")
	public List<WebElement> vendors;
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root Button ']")
	public List<WebElement> addToFav;
	
	public void offers() {
		
		offers.click();
		//new Actions(driver).moveToElement(offers).click().build().perform();
	}
	
	public void orders() {
		orders.click();
	}
	
	public void favourites() {
		favourites.click();
	}
	
	public void bag() {
		bag.click();
	}
	
	public void login() {
		signIn.click();
	}
	
	public void orderByDD(String str) {
		Select s=new Select(orderBy);
		s.selectByVisibleText(str);
	}
	
	public void vendor(String str) {
		for(WebElement v:vendors) {
			if(v.getAttribute("value").equals(str)) {
				new Actions(driver).moveToElement(v).click().build().perform();
				break;
			}
		}
	}
	
	public int addToFavs() {
		
		for(WebElement a:addToFav) {
			cnt++;
			a.click();
			
		}
		return cnt;
	}
}
