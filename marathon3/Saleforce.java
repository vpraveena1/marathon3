package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*Test case : 001 (Chrome)
====================
01) Launch https://login.salesforce.com/ 
02) Login to Salesforce with your username and password
03) Click on the App Launcher (dots)
04) Click View All
05) Type Content on the Search box
06) Click Content Link
07) Click on Chatter Tab
08) Verify Chatter title on the page
09) Click Question tab
10) Type Question with data (coming from excel)
11) Type Details with data (coming from excel)
12) Click Ask
13) Confirm the question appears
14) Close the browser
*/
public class Saleforce extends ProjectSpecificMethod {

	
		
		@BeforeTest
		public void opnDb()
		{
			excelFile="Chatter";
		}
	@Test(dataProvider="fData")
	public void chatterTab(String question,String Answer)
	{
	
    	driver.findElement(By.xpath("(//p[@class='slds-truncate'])[4]")).click();
    	WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
        driver.executeScript("arguments[0].click();",chatter );
        
    	driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
    	System.out.println(driver.getTitle());
    	driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(question);
     driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(Answer);
     driver.findElement(By.xpath("(//button[@type='button'])[49]")).click();
     String text = driver.findElement(By.xpath("//span[text()='How was the class going']")).getText();
     String text1="How was the class going";
     
     String text2 = driver.findElement(By.xpath("//span[text()='Its going great']")).getText();
    
    if(text.contains(text1))	
    {
    	System.out.println("Yes this is my question");
    }
    else
    {
    	System.out.println("Its not my Question");
    }
	
	System.out.println(text1);
	System.out.println(text2);
	}
}


