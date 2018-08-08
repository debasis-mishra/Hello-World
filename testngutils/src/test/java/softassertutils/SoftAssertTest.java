package softassertutils;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void verifySoftAssert1()
	{
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Inside soft assert. before soft assert.......");
		softAssert.assertTrue(false);
		System.out.println("After soft assert.........");
		softAssert.assertAll();
	}
	
	@Test
	public void verifySoftAssert2()
	{
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Inside soft assert. before soft assert.......");
		softAssert.assertTrue(false);
		System.out.println("After soft assert.........");
	}
	
	@Test
	public void verifyHardAssert()
	{
		System.out.println("Inside hard assert. before hard assert.......");
		Assert.assertTrue(false);
		System.out.println("After hard assert.........");
	}
}
