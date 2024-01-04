package bstack.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bstack.pageObjects.LoginPage;
import bstack.utilities.ReadLoginData;
import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

public class LoginTest_001 extends BaseClass {
	
	@BeforeClass
	public void beforeTest() throws InterruptedException {
		driver.findElement(By.id("signin")).click();
		Thread.sleep(1000);
		log.info("Click on SignIn ");	
	}
	
	@Test(dataProvider="loginData")
	public void loginTest(String uname,String upsw) throws InterruptedException, IOException {
		
		
		LoginPage lp=new LoginPage(driver);
		lp.userName(uname);
		lp.psw(upsw);
		lp.login();
		
		try {
		    if (driver.findElement(By.id("logout")).isDisplayed()) {
		    	 Assert.assertTrue(true);
				    log.info("Login Successful");
				    Thread.sleep(1000);
				    lp.userLogout();
				    afterLogout();
		    }
		} catch (Exception e) {
			takeSs(driver,"LoginTest");
			log.error(driver.findElement(By.className("api-error")).getText());
			Assert.assertTrue(false);
		    
		    
		    
		}
	 }
	
	@DataProvider(name="loginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/bstack/testData/BStackLogin.xlsx";
		int rowNum=ReadLoginData.getRow(path,"Sheet1");
		int colNum=ReadLoginData.getCol(path, "Sheet1", rowNum);
		String loginData[][]=new String[rowNum][colNum];
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				loginData[i-1][j]=ReadLoginData.cellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
