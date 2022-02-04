package assign.serviceday1;


import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  
	public ChromeDriver driver;
	
  @BeforeMethod
  public void loginPart() throws InterruptedException {
 
	  WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://dev97515.service-now.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Jesussavesyou1*");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//Search “incident “ Filter Navigator
		WebElement fe = driver.findElement(By.id("filter"));
		
		fe.sendKeys("Incident",Keys.ENTER);
		
		
  
  }

  @AfterMethod
  public void closeBrowser() {
	  
	  driver.close();
  }

  
}
