package assignments.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class DeleteLead extends BaseClass{
	
        @Test
		public void deleteLead() throws InterruptedException {
        
        	
    		driver.findElement(By.linkText("Leads")).click();
    		driver.findElement(By.linkText("Find Leads")).click();
    		driver.findElement(By.xpath("//span[text()='Phone']")).click();
    		 WebElement dd1 = driver.findElement(By.xpath("//input[@name='phoneCountryCode']"));
    	        dd1.sendKeys("5"); 
    	        
    	        WebElement dd2 = driver.findElement(By.xpath("//input[@name='phoneAreaCode']"));
    	        dd2.sendKeys("23");
    	           
    	        WebElement dd3= driver.findElement(By.xpath("//input[@name='phoneNumber']"));
    	        dd3.sendKeys("1234");
    		   Thread.sleep(2000);
    		
    	      
            //Capture lead ID of First Resulting lead
               
             WebElement cp = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//td[1]//a"));
             String id1=cp.getText();    
             System.out.println(id1);
             
             cp.click();
    		
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
            System.out.println(result);	
 		
    		
			
		
	}

}
