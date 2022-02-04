package assignments.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


    public class EditLead extends BaseClass{
    	
    	@Test
    	public void editLead() throws InterruptedException {
    		  
    		
    			driver.findElement(By.linkText("Create Lead")).click();
    			
    			driver.findElement(By.linkText("Find Leads")).click();
    			
    			driver.findElement(By.linkText("Email")).click();
    			
    			driver.findElement(By.xpath("//input[@name='emailAddress' and @type='text']")).sendKeys("abc@gmail.com");
    			
    			driver.findElement(By.linkText("Find Leads")).click();
    			
    			Thread.sleep(500);
    			
    			WebElement cap = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
    			
    			String id1 = cap.getText();
    			
    			System.out.println("LeadID is " +id1);
    			
    			
    			Thread.sleep(500);
    			
    			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
    			
    			String companyName1 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
    			
    			System.out.println("Captured company name is " + companyName1);
    		
    			driver.findElement(By.linkText("Edit")).click();
    			
    			driver.findElement(By.id("updateLeadForm_companyName")).clear();
    			
    			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("New Solutions");
    				
    			driver.findElement(By.className("smallSubmit")).click();
    			
    			System.out.println("Captured title is " + driver.getTitle());
    						
    			if(driver.getTitle().contains("View Lead")) {
    				System.out.println("Title verified");
    			}
    			else {
    				System.out.println("Title not matching");
    			}
    			
    			
    			String companyName2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
    			
    			System.out.println("Captured Duplicate company name is " + companyName2);
    			
    		
    			if(companyName1.equals(companyName2)) {
    				System.out.println("Company Name unchanged");
    			}
    			else {
    				System.out.println("Company Name changed");
    			}
	
    	
    	}

}
