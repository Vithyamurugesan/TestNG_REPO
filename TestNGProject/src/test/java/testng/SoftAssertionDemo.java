package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SoftAssertionDemo {

			
		  public WebDriver driver;
		  SoftAssert as=new SoftAssert();
		  @BeforeTest
		  public void beforeTest() {
			  ChromeOptions options=new ChromeOptions();
			  options.addArguments("--start-maximized");
			  options.addArguments("--headless");   //browser guy is not opened
			  driver = new ChromeDriver(options); 
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.get("https://www.demoblaze.com/");
			 
		  }
		    
		  @Test()
		  public void validation() {
			  driver.findElement(By.id("login2")).click();
			  driver.findElement(By.id("loginusername")).sendKeys("vithyamurugesan");
			  driver.findElement(By.id("loginpassword")).sendKeys("1234");
			  driver.findElement(By.xpath("//button[text()='Log in']")).click();
			  
			  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			  WebElement welcome=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		      String expected=welcome.getText();
		      String actual="Welcome vithyamurugesan";
			  as.assertEquals(actual,expected); 
			  as.assertAll();
			  
		  }
		  
		 
		  

		  @AfterTest
		  public void afterTest() {
			  driver.quit();
		  }
	}