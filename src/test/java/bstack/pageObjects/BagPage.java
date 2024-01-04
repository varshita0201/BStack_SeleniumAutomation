package bstack.pageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class BagPage {
	WebDriver driver;

	public BagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='float-cart__shelf-container']//div[@class='shelf-item']")
	public List<WebElement> delete;

	@FindBy(xpath = "//div[@class=\"float-cart__close-btn\"]")
	public WebElement close;

	@FindBy(xpath = "//div[@class='float-cart__shelf-container']//div[@class='shelf-item']")
	public List<WebElement> quantity;

	@FindBy(xpath = "//div[@class=\"buy-btn\"]")
	public WebElement checkout;

//	@FindBy(xpath="//button[@class='change-product-button']")
//	public List<WebElement> sym;

	public void delItems(String str) throws InterruptedException {
		for (WebElement d : delete) {
			String pname = d.findElement(By.xpath(".//p[@class='title']")).getText();
			if (pname.equals(str)) {
				Thread.sleep(1000);
				System.out.println("In delete***");
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();",
						d.findElement(By.xpath(".//div[@class='shelf-item__del']")));
				break;
			}
		}
	}

	public void closeBag() {
		close.click();
	}

	public void quantityChange(String symbol, String str) throws InterruptedException {
		
		for(WebElement a:quantity) {
			String name=a.findElement(By.xpath(".//p[@class='title']")).getText();
			
			if(name.equals(str)) {	
				int cnt=1;
				List<WebElement> sym=a.findElements(By.xpath(".//button[@class='change-product-button']"));
				if(symbol.equals("+") && cnt==1) {
					cnt++;
					WebElement elm=sym.get(1);
					elm.click();
				}else if(cnt>1 && symbol.equals("-")) {
					cnt--;
					WebElement elm=sym.get(0);
					elm.click();
				}
				Thread.sleep(1000);
				break;
			}	
		}
	}

	public void checkOut() {
		checkout.click();
	}
}
