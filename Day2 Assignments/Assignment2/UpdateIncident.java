package week5.serviceassign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass{
	
	@BeforeClass
	public void setMethod() {
		
		setFileName = "UpdateIncident";
	}
	
	@Test(dataProvider="fetchData")	
	public void updateIncident(String name) throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		driver.switchTo().frame("gsft_main");
		
driver.findElement(By.xpath("//table[@id='incident_table']/thead[1]/tr[2]/td[6]/div[1]/div[1]/div[1]/input[1]")).sendKeys(name,Keys.ENTER);   		
		
driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();

String ref = driver.findElement(By.id("incident.number")).getAttribute("value");
System.out.println("Incident No.:"+ ref);


driver.findElement(By.xpath("//select[@id='incident.state']/option[2]")).click();

driver.findElement(By.xpath("//select[@id='incident.urgency']/option[1]")).click();


WebElement fe1 = driver.findElement(By.xpath("(//textarea[@data-stream-text-input='work_notes'])[2]"));
fe1.sendKeys("Updated");

driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();


WebElement fe2 = driver.findElement(By.id("incident_table_header_search_control"));
fe2.sendKeys(ref,Keys.ENTER);

String text = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();

String text2 = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[contains(text(),'In Progress')]")).getText();

if(ref.equals(text) && text2.contains("Progress")) {
	
	System.out.println("Incident Updated");
	
}else {
	
	System.out.println("Not updated");
}

		
	}

}
