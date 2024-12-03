package rahulshettyacademy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);//bcoz, AbstractComponent doesnot have driver,AbstractComponent is a parent class of current class so we can send driver to AbstractComponent using super keyword
		//If we are using super keyword in child class, then all the children of that parent class should use super keyword
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Pagefactory
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//u can write above code using pagefacory as follows
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	
	
	public ProductCatalogue loginApplication(String email,String paswrd)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(paswrd);
		login.click();
		//we know that after login click product catalogue page will open so,
		//instead of creating object in SubmitOrderTest.java page, you can encapsulate object creation inside the method
		//here the method returns object(ProductCatalogue)
		ProductCatalogue prodCat = new ProductCatalogue(driver);
		return prodCat;
	}
	public String getErrorMsg()
	{
		waitForElementToAppearWeb(errorMsg);
		return errorMsg.getText();
		}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
