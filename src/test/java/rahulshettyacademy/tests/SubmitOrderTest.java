package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameworkDesign.CartPage;
import rahulshettyacademy.SeleniumFrameworkDesign.CheckoutPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ConfirmationPage;
import rahulshettyacademy.SeleniumFrameworkDesign.LandingPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseClass;

public class SubmitOrderTest extends BaseClass{

	@Test
	public void submitOrder() throws IOException
	{
	
		String productName = "ZARA COAT 3";


		ProductCatalogue prodCat = lndgPg.loginApplication("anshika@gmail.com", "Iamking@000");

		List<WebElement> products = prodCat.getProductList();
		prodCat.addProductToCart(productName);
		// you can access AbstractComponent method using ProductCatalogue object bcoz,
		// ProductCatalogue is children of AbstractComponent
		CartPage cartpg = prodCat.goToCartPage();

		boolean match = cartpg.checkMatch(productName);
		// you can not write assert inside the page object bcoz, assert used for
		// validationg tets case
		// only actions can write inside the page object
		Assert.assertTrue(match);
		CheckoutPage chkoutPg = cartpg.goToCheckOut();
		chkoutPg.selectCountry("India");
		ConfirmationPage cnfrmPg = chkoutPg.placeOrder();
		String text = cnfrmPg.confirmation();
		Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}

}
