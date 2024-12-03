package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameworkDesign.LandingPage;

public class BaseClass {
	WebDriver driver;
	public LandingPage lndgPg;
	public WebDriver intialseDriver() throws IOException
	{
		
		 
		
		//ref.notes
		Properties prop=new Properties();
	
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resourses\\GlobalData.properties");
		prop.load(fs);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
			{;
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
			}
		else	if(browserName.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//edge
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver=intialseDriver();
		 lndgPg = new LandingPage(driver);
		lndgPg.goTo();
		return lndgPg;
	}
	
}
