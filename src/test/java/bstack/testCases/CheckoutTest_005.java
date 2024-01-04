package bstack.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bstack.pageObjects.AddToCartPage;
import bstack.pageObjects.BagPage;
import bstack.pageObjects.CheckoutPage;
import bstack.pageObjects.HomePage;
import bstack.pageObjects.LoginPage;
import bstack.utilities.ReadCheckoutData;

public class CheckoutTest_005 extends BaseClass {
	
	@BeforeClass
	public void beforeTest() {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		AddToCartPage atcp=new AddToCartPage(driver);
		BagPage bp=new BagPage(driver);
		hp.login();
		lp.userName("demouser");
		lp.psw("testingisfun99");
		lp.login();
		atcp.addTocart("Galaxy S9");
		bp.checkOut();
	}
	
	@Test(dataProvider="checkoutData")
	public void checkoutTest(String firstname, String lastname, String address, String state, String postalCode) throws InterruptedException {
		CheckoutPage cp=new CheckoutPage(driver);
		cp.firstname(firstname);
		cp.lastname(lastname);
		cp.addresS(address);
		cp.stateName(state);
		cp.postCode(postalCode);
		cp.ckSubmit();
		
		try {
			if(driver.findElement(By.id("confirmation-message")).isDisplayed()) {
				Assert.assertTrue(true);
				log.info("Your Order has been successfully placed.");
				Thread.sleep(1000);
				continueShopping();
			}
		}catch(Exception e) {
			log.error("Fill the details");
			Thread.sleep(1000);
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="checkoutData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/bstack/testData/BStackLogin.xlsx";
		int rowNum=ReadCheckoutData.getRow(path,"Sheet2");
		int colNum=ReadCheckoutData.getCol(path,"Sheet2", rowNum);
		String checkoutData[][]=new String[rowNum][colNum];
		for(int i=1;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				checkoutData[i-1][j]=ReadCheckoutData.cellData(path,"Sheet2", i, j);
			}
		}
		return checkoutData;
	}
	
	public void continueShopping() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='button button--tertiary optimizedCheckout-buttonSecondary']")).click();
		log.info("Clicked on Continue Shopping");
		AddToCartPage atcp=new AddToCartPage(driver);
		BagPage bp=new BagPage(driver);
		atcp.addTocart("Galaxy S9");
		Thread.sleep(1000);
		bp.checkOut();
		
	}
}
