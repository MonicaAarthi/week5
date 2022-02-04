package assign.serviceday1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateIncident extends BaseClass {

	public String ref;
	
	     @Test(alwaysRun=true)
		public void createIncident() throws InterruptedException {
		     
	    	 driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
	    	 
	    	 driver.switchTo().frame("gsft_main");
	    	 
	    	 ref = driver.findElement(By.id("incident.number")).getAttribute("value");
	 		
	 		System.out.println("Reference Number:" +ref);
	 	
	 		//Select a value for Caller 
	 		driver.findElement(By.id("lookup.incident.caller_id")).click();
	 			
	 		Set<String> windowHandles1= driver.getWindowHandles();
	 		
	 		List<String> window1 = new ArrayList<String>(windowHandles1);
	 		
	 		driver.switchTo().window(window1.get(1));
	 		
	 		Thread.sleep(3000);
	 		
	 		driver.findElement(By.linkText("Abel Tuter")).click();
	 		
	 		driver.switchTo().window(window1.get(0));
	 		
	 		driver.switchTo().frame("gsft_main");
	 		
	 		//Enter value for short_description
	 		driver.findElement(By.id("lookup.incident.short_description")).click();
	 		
	 		Set<String> windowHandles2 = driver.getWindowHandles();
	 		
	 		List<String> window2 = new ArrayList<String>(windowHandles2);
	 		
	 		driver.switchTo().window(window2.get(1));
	 		
	 		Thread.sleep(3000);
	 		
	 		driver.findElement(By.linkText("Issue with a web page")).click();
	 		
	 		driver.switchTo().window(window2.get(0));
	 		
	 		driver.switchTo().frame("gsft_main");
	 		
	 		//Click on Submit button
	 		driver.findElement(By.id("sysverb_insert_bottom")).click();
	 		
	 		Thread.sleep(3000);
	 		
	 		driver.findElement(By.xpath("//select[@role='listbox']/option[2]")).click();
	 		
	 		//search for created incident number and storing the attribute value
	 	driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input")).sendKeys(ref,Keys.ENTER);
	 	
	 	String attribute = driver.findElement(By.xpath("(//tbody//td/a)[2]")).getAttribute("aria-label");
	 	
	 	//verifying the ref no is same
	 	if(attribute.contains(ref)) {
	 		
	 		System.out.println("Created Incident is verified");
	 	
	 	}else {
	 		
	 		System.out.println("Incident is not created");
	 	}
	 	
	}

}
