package bstack.testCases;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import bstack.pageObjects.AddToCartPage;
import bstack.pageObjects.BagPage;
import bstack.pageObjects.HomePage;
import bstack.pageObjects.LoginPage;

public class BagTest_004 extends BaseClass {
	
	@Test
	public void bagTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hp=new HomePage(driver);
		BagPage bp=new BagPage(driver);
		LoginPage lp=new LoginPage(driver);
		AddToCartPage atcp=new AddToCartPage(driver);
		hp.login();
		lp.userName("demouser");
		lp.psw("testingisfun99");
		lp.login();
		Thread.sleep(1000);
		atcp.addTocart("iPhone 11 Pro");
		log.info("iPhone 11 Pro added");
		Thread.sleep(1000);
		atcp.addTocart("Pixel 3");
		log.info("Pixel 3");
		Thread.sleep(1000);
		atcp.addTocart("One Plus 7T");
		log.info("One Plus 7T");
		
		Thread.sleep(3000);
		bp.quantityChange("+", "Pixel 3");
		log.info("Quantiy :Pixel 3 increased");
		Thread.sleep(3000);
		
		
		bp.delItems("iPhone 11 Pro");
		log.info("Deleted iPhone 11 Pro");
		Thread.sleep(1000);
		bp.closeBag();
		log.info("Bag Closed");
		
		Thread.sleep(1000);
		hp.bag();
		Thread.sleep(1000);
		log.info("Clicked on Bag");
		
		bp.checkOut();
		Thread.sleep(1000);
		log.info("Clicked on CheckOut Page");
		Assert.assertEquals(driver.findElement(By.xpath("//legend[@class='form-legend optimizedCheckout-headingSecondary']")).getText(),"Shipping Address");
		log.info("In CheckOut Page");
		
		
		
	}
}
