package rahulshettyacademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountry;

	By loadCountry = By.cssSelector(".ta-results");

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement country;

	@FindBy(css = ".action__submit")
	WebElement submit;

	@FindBy(css = ".hero-primary")
	WebElement confirmMsg;
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement dropDownCountry;
	
	
	
	public boolean checkMatch(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(productName));
		
		return match;

	}
	public CheckoutPage goToCheckOut() {
	
		
		checkOut.click();
		CheckoutPage chkoutPage = new CheckoutPage(driver);
		return chkoutPage;

	}

	public void selectCountry() {
		Actions a = new Actions(driver);
		a.sendKeys(dropDownCountry,"India").build().perform();
		waitForElementToAppear(loadCountry);
		country.click();
	}

	public void placeOrder() {
		selectCountry();
		submit.click();
		String text=confirmMsg.getText();
		Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
}
