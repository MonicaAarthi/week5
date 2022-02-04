package week5.serviceassign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass {

	@BeforeClass
	public void setMethod() {
		
		setFileName = "DeleteIncident";
	}
	
	
	 @Test(dataProvider="fetchData")
			public void deleteIncident(String name) {
	        
	        	driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
	    		
	    		driver.switchTo().frame("gsft_main");
	    		
	   driver.findElement(By.xpath("//table[@id='incident_table']/thead[1]/tr[2]/td[6]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name,Keys.ENTER);
	    		
	       driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();

	       String ref = driver.findElement(By.id("incident.number")).getAttribute("value");
	       System.out.println("Incident No.:"+ ref);
	       
	       driver.findElement(By.id("sysverb_delete")).click();
	          
	        driver.findElement(By.id("ok_button")).click();
	       
	       
	       driver.findElement(By.id("incident_table_header_search_control")).sendKeys(ref,Keys.ENTER);
	       
	        String text = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
	        
	        if(text.contains("No records")) {
	        	
	        	System.out.println("Incident deleted");
	        }else {
	        	
	        	System.out.println("Incident not deleted");
	        }
	       
	       
	 }
	
	
}
