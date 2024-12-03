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

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	By loadCountry = By.cssSelector(".ta-results");

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement Selectcountry;

	@FindBy(css = ".action__submit")
	WebElement submit;

	
	
	
	
	
	
	

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(loadCountry);
		Selectcountry.click();
	}

	public ConfirmationPage placeOrder() {
		
		submit.click();
		ConfirmationPage cnfrmPage=	new ConfirmationPage(driver);
		return cnfrmPage;
		
	}
	
}
