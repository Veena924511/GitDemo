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

public class ErrorValidations extends BaseClass{

	@Test
	public void submitOrder() throws IOException
	{
	
		String productName = "ZARA COAT 3";


		ProductCatalogue prodCat = lndgPg.loginApplication("anshika@gmail.com", "Iamking@000");
	
		Assert.assertEquals("Incorrect email or password.",lndgPg.getErrorMsg() );

		Assert.assertEquals("Incorrect email or password.",lndgPg.getErrorMsg() );

		Assert.assertEquals("Incorrect email or password.",lndgPg.getErrorMsg() );

	}

}
