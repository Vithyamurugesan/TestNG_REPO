package testng;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo1 {
	WebDriver driver;
	@DataProvider(name="testData")
	public Object[][] dataProvFunc(){
		return new Object[][] {{"Selenium"},{"TestNG"}};
	}

  @BeforeMethod
  public void setUp() {
	  System.out.println("Start the test");
	  driver=new ChromeDriver();
	  driver.get("https://www.bing.com/");
	  driver.manage().window().maximize();
  }
  @Test(dataProvider="testData")
  public void search(String Keyword) {
	  WebElement txtbox=driver.findElement(By.id("sb_form_q"));
	  txtbox.sendKeys(Keyword);
	  System.out.println("Keyword entered is "+Keyword);
	  txtbox.sendKeys(Keys.ENTER);
	  System.out.println("Search result is displayed");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("End the test");
  }

}