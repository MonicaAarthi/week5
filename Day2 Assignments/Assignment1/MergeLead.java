package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MergeLead extends BaseClass {

	@BeforeClass
    public void setMethod() {
		
		setFileName = "MergeLead";
	}
	
	@Test(dataProvider="fetchData")
	public void mergeLead(String fName,String lName) throws InterruptedException {
	
	driver.findElement(By.xpath("//a[text()='Leads']")).click();
	
	driver.findElement(By.linkText("Merge Leads")).click();
	//Thread.sleep(3000);
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	
	Set<String> windowHandles1 = driver.getWindowHandles();
	List<String> windows1 = new ArrayList<String>(windowHandles1);
	driver.switchTo().window(windows1.get(1));
	
	driver.findElement(By.name("firstName")).sendKeys(fName);
	driver.findElement(By.name("lastName")).sendKeys(lName);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

	Thread.sleep(1000);
	
	String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(windows1.get(0));
	
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	
	Set<String>  windowHandles2 = driver.getWindowHandles();
	List<String> windows2 = new ArrayList<String>(windowHandles2);
	driver.switchTo().window(windows2.get(1));
	
	driver.findElement(By.name("firstName")).sendKeys(fName);
	driver.findElement(By.name("lastName")).sendKeys(lName);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
	driver.switchTo().window(windows2.get(0));
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
	
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	String text = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
	//System.out.println(text);
	
	if (text.contains("No records")) {
		System.out.println("Lead Merged");
	} else {
		System.out.println("Not merged");
	}
	
}
}
