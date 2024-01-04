package bstack.pageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	WebDriver driver;
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='shelf-item'][@id]")
	public List<WebElement> products;
	
	public void addTocart(String str) {
		for(WebElement p:products) {
			String pname=p.findElement(By.xpath(".//p[@class='shelf-item__title']")).getText();
			if(pname.equals(str)) {
				p.findElement(By.xpath(".//div[@class='shelf-item__buy-btn']")).click();
			}
		}
	}
	
	
}
