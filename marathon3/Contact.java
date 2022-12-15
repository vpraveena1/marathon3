package marathon3;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Contact extends ProjectSpecificMethod{
	@BeforeTest
	public void opnDb()
	{
		excelFile="ContactTab";
	}
@Test(dataProvider="fData")
	public void contactTab(String salute,String fname,String lname, String pnum,String email,String title,String account) throws InterruptedException {
	
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Contact");
	driver.findElement(By.xpath("(//mark[text()='Contact'])[4]")).click();
	driver.findElement(By.xpath("//div[@title='New']")).click();
	driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[1]")).sendKeys(salute);
	driver.findElement(By.xpath("//span[@title='Mrs.']")).click();
	driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(fname);
	driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(lname);
	driver.findElement(By.xpath("(//input[contains(@class,'slds-combobox__input slds-input')])[1]")).sendKeys(account);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//lightning-base-combobox-formatted-text[@class='slds-truncate'])[1]")).click();
	driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(pnum);
	driver.findElement(By.xpath("(//input[@class='slds-input'])[12]")).sendKeys(email);
	driver.findElement(By.xpath("(//input[@class='slds-input'])[7]")).sendKeys(title);
	driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
 String text=driver.findElement(By.xpath("//span[@class='custom-truncate uiOutputText']")).getText();
	System.out.println(text);
	
	
}
}