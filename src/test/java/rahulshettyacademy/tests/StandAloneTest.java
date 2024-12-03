package rahulshettyacademy.tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameworkDesign.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String productName="ZARA COAT 3";
		String productName1="ZARA COAT 31";
		String productName2="ZARA COAT 322";
		driver.get("https://rahulshettyacademy.com/client");
		driver.get("https://rahulshettyacademy2.com/client");
		driver.get("https://rahulshettyacademy.1com/client");
	
		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// below wait.until will take some time to load next page(performance issue)
	//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));	
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		// so instead of above method,i we use below method it loads faster
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//grab the selected items from my cart page and check if it has zara coat 3
	List<WebElement> cartProducts=	driver.findElements(By.cssSelector(".cartSection h3"));
	//if we use anymatch instead of filter it will return true if there any zara coat 3 else return false
	Boolean match=	cartProducts.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	//to select country
	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	String confirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	//driver.close();
	
	}

}
