package assign.serviceday1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class AssignIncident extends BaseClass {

	@Test(priority=3)
	public void assignIncident() throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		driver.switchTo().frame("gsft_main");
		
driver.findElement(By.xpath("//table[@id='incident_table']/thead[1]/tr[2]/td[6]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Abel",Keys.ENTER); 		
		
   driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();

   String ref = driver.findElement(By.id("incident.number")).getAttribute("value");
   System.out.println("Incident No.:"+ ref);

 driver.findElement(By.xpath("//input[@data-name='assignment_group']/following-sibling::span[2]")).click();

  Set<String> windowHandles1 = driver.getWindowHandles();

  List<String> window1 = new ArrayList<String>(windowHandles1);

  driver.switchTo().window(window1.get(1));
  
  driver.findElement(By.id("sys_user_group_table_header_search_control")).sendKeys("software",Keys.ENTER);
  
  driver.findElement(By.xpath("//a[contains(text(),'Software')]")).click();
  
  //driver.switchTo().defaultContent();
   
  driver.switchTo().window(window1.get(0));
  
  driver.switchTo().frame("gsft_main");

  driver.findElement(By.id("activity-stream-textarea")).sendKeys("Assigned");
	
	
	driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
	
	WebElement fe1 = driver.findElement(By.id("incident_table_header_search_control"));
	fe1.sendKeys(ref,Keys.ENTER);
	
   String text = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
   
   String text2 = driver.findElement(By.xpath("(//td[@class='vt']/a)[3]")).getText();
	
	if(ref.equals(text) && text2.contains("Software")) {
		
		System.out.println("Incident assigned to software group");
		
	}else {
		
		System.out.println("Not assigned");
	}
	
	          
	}

}
