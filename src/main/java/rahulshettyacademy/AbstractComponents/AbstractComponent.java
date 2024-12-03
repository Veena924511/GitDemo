package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.SeleniumFrameworkDesign.CartPage;

public class AbstractComponent {
	WebDriver driver;
	//this constructor is used to catch the driver from child class(super)
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	//instead of writing webdriver wait repeatedly we can do like this
	public void waitForElementToAppear(By findBy)
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	//here we are using By.cssSelector(".mb-3")) not the entire findElementBy(id(----))
	//so,findElementBy(id(----)) returns webelement and By.cssSelector(".mb-3")) returns By
	}
	public void waitForElementToAppearWeb(WebElement element)
	{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public void waitForElementToDisappear(WebElement ele)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	//We are writing goToCartPage() here bcoz, in this method we are clicking on cart which is common to all page, so we can 
	//reuse this method whenever we want, so writing it in parent class
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage crtpg=new CartPage(driver);
		return crtpg;
	}
	
}
