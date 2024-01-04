package bstack.testCases;

import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import bstack.pageObjects.HomePage;

public class HomePageTest_002 extends BaseClass {
	@Test
	public void homepage() throws InterruptedException {
		
		
		HomePage hp=new HomePage(driver);
		hp.offers();
		log.info("Clicked on Offers");
		commonStepsInHomePage();
		
		hp.orders();
		log.info("Clicked on orders");
		commonStepsInHomePage();
		
		hp.favourites();
		log.info("Clicked on favourites");
		commonStepsInHomePage();
		
		hp.bag();
		log.info("Clicked on bag");
		if(driver.getPageSource().contains("Add some products in the bag ")) {
			Assert.assertTrue(true);
			log.info("Bag is Displayed");
		}
		
		hp.login();
		log.info("Clicked on SignIn");
		commonStepsInHomePage();
		
		List<WebElement> beforeLToH = driver.findElements(By.xpath("//div[@class='val']//b"));
		List<Integer> beforeValues= new ArrayList<>();
		for(WebElement e:beforeLToH) {
			beforeValues.add(Integer.parseInt(e.getText()));
		}
		
		hp.orderByDD("Lowest to highest");
		Thread.sleep(1000);
		log.info("Lowest to Highest Clicked");
		checkIsLtoH(beforeValues);
		Thread.sleep(1000);
		
		hp.orderByDD("Highest to lowest");
		Thread.sleep(1000);
		checkIsHtoL(beforeValues);
		toHomePage();
		
		Thread.sleep(1000);
		hp.vendor("Apple");
		isSorted("iPhone");
		Thread.sleep(2000);
		toHomePage();
		
		Thread.sleep(2000);
		hp.vendor("Samsung");
		isSorted("Galaxy");
		Thread.sleep(2000);
		toHomePage();
		
		Thread.sleep(2000);
		hp.vendor("Google");
		isSorted("Pixel");
		Thread.sleep(2000);
		toHomePage();
		
		Thread.sleep(2000);
		hp.vendor("One Plus");
		isSorted("One Plus");
		Thread.sleep(2000);
		toHomePage();
	}
	
	public void commonStepsInHomePage() throws InterruptedException {
			System.out.println(driver.getPageSource().contains("Log In")?"Yes":"No");
		if((driver.findElement(By.id("login-btn")).getText()).equalsIgnoreCase("Log In")) {
			Assert.assertTrue(true);
			log.info("In SignIn Page");
			Thread.sleep(1000);
			toHomePage();
		}
		Thread.sleep(1000);
	}
	
	public void checkIsLtoH(List<Integer> beforeValues) {
		List<WebElement> afterLToH=driver.findElements(By.xpath("//div[@class=\"val\"]//b"));
		List<Integer> afterValues=new ArrayList<>();
		for(WebElement e:afterLToH) {
			afterValues.add(Integer.parseInt(e.getText()));
		}
		
		Collections.sort(beforeValues);
		System.out.println(beforeValues.equals(afterLToH)?"Yes":"No");
		Assert.assertEquals(beforeValues,afterValues);
		log.info("In Ascending Order");
	}
	
	public void checkIsHtoL(List<Integer> beforeValues) {
		log.info("IN High to Low");
		List<WebElement> afterLToH=driver.findElements(By.xpath("//div[@class=\"val\"]//b"));
		List<Integer> afterValues=new ArrayList<>();
		for(WebElement e:afterLToH) {
			afterValues.add(Integer.parseInt(e.getText()));
		}
		
		Collections.sort(beforeValues,Collections.reverseOrder());
		Assert.assertEquals(beforeValues,afterValues);
		log.info("In Descending Order");
	}
	
	public void isSorted(String str) {
		List<WebElement> sort=driver.findElements(By.className("shelf-item__title"));
		boolean b=false;
		for(WebElement l:sort) {
			if(l.getText().contains(str)) {
				b=true;
			}
		}
		if(b==true) {
			Assert.assertTrue(true);
			log.info("Only specific brand items are displayed:"+str);
		}else {
			log.error("All brand items are displayed");
			Assert.assertTrue(false);
		}
	}
}
