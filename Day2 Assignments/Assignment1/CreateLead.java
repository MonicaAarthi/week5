package week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@BeforeClass
	public void setMethod() {
		
		setFileName = "CreateLead";
	}
	
	
	     @Test(dataProvider="fetchData")
		public void createLead(String cName, String fName, String lName) {
		
	    
	 		driver.findElement(By.linkText("Leads")).click();
	 		driver.findElement(By.linkText("Create Lead")).click();
	 		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	 		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	 		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	 		driver.findElement(By.name("submitButton")).click();

	}
	     
	   
}
