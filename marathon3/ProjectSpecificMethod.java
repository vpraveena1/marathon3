package marathon3;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethod {
	public RemoteWebDriver driver;
   public String excelFile;
  @Parameters({"browser","url","username","password"})
  @BeforeMethod
  public void launchBrowser(String browser,String url,@Optional("vpraveena1@saleforce.com") String username,String password) {
		//option browser for cross browser testing
	  if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
	  driver.manage().window().maximize();
	  driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
				
  }
  @AfterMethod
  public void close() {
  driver.close();
}
  //dataprovider common to (create,edit)
  @DataProvider(name = "fData")
	public String[][] getData() throws IOException { // r//c
		String[][] readdata = ReadExcel.readdata(excelFile);// ctrl+2+l
		return readdata;
	}
}
	




	 