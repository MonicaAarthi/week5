package assignments.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {

	@Test
	public void duplicateLead() throws InterruptedException {
		
	        driver.findElement(By.xpath("//a[text()='Leads']")).click();
	            
	        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	           
	        driver.findElement(By.xpath("//span[text()='Email']")).click();
	           
	        driver.findElement(By.name("emailAddress")).sendKeys("abcde@gmail.com");
	           
	        WebElement cc = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
	        
	        String name1=cc.getText();
	        
	        System.out.println(name1);
	            
	        cc.click();
	         
	        driver.findElement(By.xpath("(//div[@class='frameSectionExtra']/a)[1]")).click();
	            
	      /*  String title=driver.getTitle();
	            
	         if(title.contains("Duplicate")) {
	            	System.out.println("Title is verified");
	            	}
	            else {
	            	System.out.println("Title mismatched");
	            	}*/
	           
	          driver.findElement(By.name("submitButton")).click();
	            
	          WebElement ld = driver.findElement(By.id("viewLead_firstName_sp"));
	          
	          String lead1=ld.getText();
	           
	          //System.out.println(lead1);
	            
	          if(name1.equalsIgnoreCase(lead1)) {
	            	System.out.println("Duplicate lead name is same as captured name");
	          }
	            else {
	            	System.out.println("Duplicate lead name is not same as captured name");
	            }
		            
	          //driver.findElement(By.name("submitButton")).click();
		
	         
	          
	}

}
