package bstack.pageObjects;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavouritesPage {
	WebDriver driver;
	public FavouritesPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root Button clicked ']")
	public List<WebElement> addToFav;
	
	public int addToFavourites() {
		int s=addToFav.size();
		return s;
	}
	
	
	
}
