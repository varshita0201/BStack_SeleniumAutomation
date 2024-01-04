package bstack.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import bstack.utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc=new ReadConfig();
	public WebDriver driver;
	public String url=rc.getAppUrl();
	public String userName=rc.getUserId();
	public String userPsw=rc.getPassword();
	public Logger log;
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(@Optional("Chrome") String bs) throws InterruptedException {
		log=LogManager.getLogger("BStackDemo");
		if(bs.equals("Chrome")) {
			driver=new ChromeDriver();
			log.info("ChromeDriver Launched");
		}
		if(bs.equals("Edge")) {
			driver=new EdgeDriver();
			log.info("MicrosoftBrowser Launched");
		}
		driver.get(url);
		log.info("Opened application url");
		driver.manage().window().maximize();
		log.info("URl Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass()
	public void closeApp() throws InterruptedException {
		Thread.sleep(1000);
		log.info("Application Closed");
		driver.quit(); 
	}
	
	public void afterLogout() {
		driver.findElement(By.id("signin")).click();
	}
	
	public void takeSs(WebDriver driver, String testName) throws IOException {
	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File dest = new File(".\\Screenshots\\" + testName + timeStampforSs() + ".png");
	        log.info("Screenshot destination successful");
	        Files.copy(src, dest);
	        log.info("Screenshot copied successfully");
	    } catch (IOException e) {
	        log.error("Error taking or copying screenshot: " + e.getMessage());
	        e.printStackTrace();
	        throw e;
	    }
	}

	public String timeStampforSs() {
		Date d=new Date();
		System.out.println("*********"+d+"*********");
		return d.toString().replace(" ","_");
	}
	
	public void toHomePage() {
		driver.get(url);
	}
}
