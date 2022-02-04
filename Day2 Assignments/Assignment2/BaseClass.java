package week5.serviceassign;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
//import week5.serviceassign.ReadExcel;

public class BaseClass {

	public ChromeDriver driver;
	
	public String setFileName;
	
	@Parameters({"url","userName","password"})
	  @BeforeMethod(alwaysRun=true)
	  public void loginPart(String url, String uName, String pwd) throws InterruptedException {
	 
		  WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			driver.get(url);
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.switchTo().frame("gsft_main");
			
			driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(uName);
			
			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(pwd);
			
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			
			//Search “incident “ Filter Navigator
			WebElement fe = driver.findElement(By.id("filter"));
			
			fe.sendKeys("Incident",Keys.ENTER);
				
	  
	  }

	  @AfterMethod(alwaysRun=true)
	  public void closeBrowser() {
		  
		  driver.close();
	  }
	  
	  @DataProvider(name="fetchData")
	  
	  public String[][] sendData() throws IOException {
		  	  
		  return ReadExcel.readExcel(setFileName);
	
}
}
