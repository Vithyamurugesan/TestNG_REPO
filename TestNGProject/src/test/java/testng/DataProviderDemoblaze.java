package testng;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DataProviderDemoblaze {
	@DataProvider(name="validData")
	public Object[][] validData(){
	    return new Object[][] {{"vithyamurugesan","1234"}};
	}

	@DataProvider(name="invalidData")
	public Object[][] invalidData(){
	    return new Object[][] {{"","1234"},{"vit","1234"},{"vithyamurugesan","1"}};
	}
	

	  public WebDriver driver;
	  @BeforeMethod
	  public void beforeMethod() {
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("--start-maximized");
		  driver = new ChromeDriver(options); 
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.demoblaze.com/");
		 
	  }
	    
	  @Test(dataProvider="validData")
	  public void validation(String name,String pass) {
		  driver.navigate().refresh();
	      driver.findElement(By.id("login2")).click();
	      driver.findElement(By.id("loginusername")).sendKeys(name);
	      driver.findElement(By.id("loginpassword")).sendKeys(pass);
	      driver.findElement(By.xpath("//button[text()='Log in']")).click();

	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	      WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	      Assert.assertTrue(welcome.getText().contains(name));
	  }
	  @Test(dataProvider="invalidData")
	  public void logininvalid1(String username,String Password) {

	      driver.navigate().refresh(); 
	      driver.findElement(By.id("login2")).click();
	      driver.findElement(By.id("loginusername")).sendKeys(username);
	      driver.findElement(By.id("loginpassword")).sendKeys(Password);
	      driver.findElement(By.xpath("//button[text()='Log in']")).click();

	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	      String alertText = alert.getText();
	      System.out.println(alertText);

	      Assert.assertTrue(alertText.contains("Please fill out Username and Password") ||alertText.contains("User does not exist") ||alertText.contains("Wrong password"));
	      alert.accept(); 
	  }
		  
		
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
}