package bstack.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import bstack.pageObjects.FavouritesPage;
import bstack.pageObjects.HomePage;
import bstack.pageObjects.LoginPage;

public class FavouritesTest_003 extends BaseClass {
	
	@Test
	public void favourites() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		FavouritesPage fp=new FavouritesPage(driver);
		hp.login();
		lp.userName("demouser");
		lp.psw("testingisfun99");
		lp.login();
		Thread.sleep(1000);
		
		int inHp=hp.addToFavs();
		Thread.sleep(1000);
		hp.favourites();
		Thread.sleep(1000);
		int inFav=fp.addToFavourites();
		log.info(inHp+" "+inFav);
		Thread.sleep(1000);
		Assert.assertEquals(inHp, inFav);
		log.info("Same Number of Products in Homepage and Favouritespage");
		if(inHp==inFav) {
			Assert.assertTrue(true);
			
		}
		
		
		
	}

}
