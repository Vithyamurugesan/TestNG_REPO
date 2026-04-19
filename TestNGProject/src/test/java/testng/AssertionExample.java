package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExample {
  @Test
  public void testAssertions() {
	  String str1=new String("TestNG");
	  String str2=new String("TestNG");
	  String str3=null;
	  String str4="TestNG";
	  String str5="TestNG";
	  String str6=new String("Not_TestNG");
	  
	  int val1=5;
	  int val2=6;
	  
	  //Check that two objects are equal
	  Assert.assertEquals(str1, str2);
	  System.out.println("Equals Assertion is successful");
	  
	  //Check that two objects are not equal
	  Assert.assertNotEquals(str1, str6);
	  System.out.println("NotEquals Assertion is successful");
	  
	  //check the condition is true
	  Assert.assertTrue(val1<val2);
	  System.out.println("True Assertion is successful");
	  
	  //check the condition is false
	  Assert.assertFalse(val1>val2);
	  System.out.println("False assertion is successful");
	  
	  //check that an object isn't null
	  Assert.assertNotNull(str1);
	  System.out.println("Not null assertion is successful");
	  
	  //check that an object is null
	  Assert.assertNull(str3);
	  System.out.println("Null assertion is successful");
	 

	  //Check if two object reference point to same object 
	  Assert.assertSame(str4, str5);
	  System.out.println("Same Assertion is successful");
	  
	  //Check if two object reference point not to same object 
	  Assert.assertNotSame(str1, str3);
	  System.out.println("NotSame Assertion is successful");
	   
	  
  }
}
