package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotations {
	
	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("----Before Suite---");
	  }
	  

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("----Before Test----");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("----Before Class----");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("----Before method----");
	  }
	  
	  
	  @Test
	  public void f() {
		  System.out.println("Test 1");
	  }
	  
	  @Test
	  public void a() {
		  System.out.println("Test 2");
	  }
	  
	  

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("----After method----");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("----After class----");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("----After Test----");
	  }
	
	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("----After Suite----");
	  }

}
