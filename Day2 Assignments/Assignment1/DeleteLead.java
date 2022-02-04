package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass{

	@BeforeClass
    public void setMethod() {
		
		setFileName = "DeleteLead";
}
	
	 @Test(dataProvider="fetchData")
		public void deleteLead(String fName,String lName) throws InterruptedException {
     
     	
 		driver.findElement(By.linkText("Leads")).click();
 		driver.findElement(By.linkText("Find Leads")).click();
 		
 		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName);
 		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys(lName);
 		
 		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
 		      
 		Thread.sleep(3000);
         //Capture lead ID of First Resulting lead
            
          WebElement cp = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//td[1]//a"));
          String id1=cp.getText();    
          System.out.println(id1);
          
          cp.click();
 		
          Thread.sleep(3000);
          
 		  //Delete
         driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[@class='subMenuButtonDangerous']")).click();
         
         //Click Find leads
         driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
         
         //Enter captured lead ID
         driver.findElement(By.xpath("//input[@name='id']")).sendKeys(id1);
         
         //Click find leads button
         driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
         
         //Verify no records
         WebElement rd = driver.findElement(By.xpath("//div[text()='No records to display']"));
         String result=rd.getText();
         
         if(result.contains("No records")) {
         	
         	System.out.println("Lead deleted");
         }else {
         System.out.println("Lead not deleted");	
		
         }
			
	 }	
}
