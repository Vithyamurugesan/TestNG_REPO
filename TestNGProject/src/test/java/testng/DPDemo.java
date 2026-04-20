package testng;


import org.testng.annotations.DataProvider;

public class DPDemo {

	@DataProvider(name="testData",parallel=true)
	public Object[][] dataProvFunc(){
		return new Object[][] {{"Selenium"},{"TestNG"}};
	}
}