package Data_Driven_Excel;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base_Class {
	 public static WebDriver driver;
	 @BeforeClass
	 public void setup() {
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		//driver=new ChromeDriver();
//		logger=Logger.getLogger("facebook");
	//	PropertyConfigurator.configure("C:\\Users\\RRR\\Documents\\Eclipse\\HybridFrameDemo\\log4j.properties");

		Scanner i=new Scanner(System.in);
		System.out.println("Enter the Browser Name");
		String browser=i.nextLine();
		
		
		if(browser.equalsIgnoreCase("chrome")){
		//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("No Such Browser Found. Try Again");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}



	@AfterClass
	 public void tearDown() {
		driver.quit();
	   }
	}


