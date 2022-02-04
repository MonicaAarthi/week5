package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {
	
	@BeforeClass
     public void setMethod() {
		
		setFileName = "DuplicateLead";
	}

	@Test(dataProvider="fetchData")
	public void duplicateLead(String fName,String lName) throws InterruptedException {
		
	        driver.findElement(By.xpath("//a[text()='Leads']")).click();
	            
	        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	       
	        driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName);
	 		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys(lName);
	 		
	 		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	          
	 		Thread.sleep(3000);
	        WebElement cc = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
	        
	        String name1=cc.getText();
	        
	        System.out.println(name1);
	            
	        cc.click();
	        
	        Thread.sleep(3000);
	        
	        driver.findElement(By.linkText("Duplicate Lead")).click();
	                 
	          driver.findElement(By.name("submitButton")).click();
	          
	          WebElement ld = driver.findElement(By.id("viewLead_firstName_sp"));
	          
	          String lead1=ld.getText();
	            
	          if(name1.equalsIgnoreCase(lead1)) {
	            	System.out.println("Duplicate lead name is same as captured name");
	          }
	            else {
	            	System.out.println("Duplicate lead name is not same as captured name");
	            }
		         

	}

	
}
