package week5.day1;

import org.testng.annotations.Test;

public class AttributesTestCase {

	@Test(priority = 1,invocationCount=2,threadPoolSize=2)
	 public void m1() {
		System.out.println("m1");	
	}
	
	@Test(alwaysRun=true)
       public void m2() {
		System.out.println("m2");	
	}
	
	@Test(enabled=false)
       public void m3() {
		System.out.println("m3");		
	}
	
	@Test(priority = -1)
	public void m4() {
		System.out.println("m4");
	}
	
	@Test(dependsOnMethods="m1")
     public void m5() {	
		System.out.println("m5");
		
	}
	
	
	
	
}
