package testng;
import org.testng.annotations.Test;

public class GroupExample {
  @Test(groups="groupA")
  public void Testgroup1forA() {
	  System.out.println("A");
	  
  }
  
  @Test(groups="groupA")
  public void Testgroup2forA() {
	  System.out.println("A"); 
  }
  
  @Test(groups="groupB")
  public void Testgroup1forB() {
	  System.out.println("B");
	 
  }
  
  @Test(groups="groupB")
  public void Testgroup2forB() {
	  System.out.println("B");
  }
  
  @Test(dependsOnGroups="groupA")
  public void TestgroupA() {
	  System.out.println("Running the dependent test");
	  
  }
}
