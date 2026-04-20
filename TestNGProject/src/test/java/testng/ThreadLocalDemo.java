package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadLocalDemo {
	 private static final ThreadLocal <WebDriver> driver=new ThreadLocal<WebDriver>();
	

	  @BeforeMethod
	  public void setUp() {
		  System.out.println("Start the test");
		  driver.set(new ChromeDriver());
	  }
	  @Test(dataProvider="testData",dataProviderClass=DPDemo.class)
	  public void search(String Keyword) {
		  WebDriver driver1=driver.get();
		  driver1.get("https://bing.com");
		  WebElement txtbox=driver1.findElement(By.id("sb_form_q"));
		  txtbox.sendKeys(Keyword);
		  System.out.println("Keyword entered is "+Keyword);
		  txtbox.sendKeys(Keys.ENTER);
		  System.out.println("Search result is displayed");	  
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  WebDriver driver1=driver.get();
		  System.out.println("After method ThreadID:"+Thread.currentThread());
		  if(driver1!=null) {
			  driver1.quit();
		  }
	  }
}
