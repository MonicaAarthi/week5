package week5.day2;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
  
	public ChromeDriver driver;
	
	public String setFileName;
	
	
  @Parameters({"url","userName","password"})	
  @BeforeMethod(alwaysRun=true)
  public void preCondition(String url,String uName, String pwd) {
 
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
  
  }

  @AfterMethod(alwaysRun=true)
  public void postCondition() {
	  
	  driver.close();
  }
  
  @DataProvider(name="fetchData")
  
  public String[][] sendData() throws IOException {
	  	  
	  return ReadExcel.readExcel(setFileName);

  }
  
  
  
}
