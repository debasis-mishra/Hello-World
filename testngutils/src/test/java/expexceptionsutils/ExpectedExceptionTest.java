package expexceptionsutils;

import org.testng.annotations.Test;
import org.testng.Assert;

import testngutils.ExpectedExceptionsEx;


//https://www.softwaretestingmaterial.com/testng-exception/
public class ExpectedExceptionTest {
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void VerifyExpectedExceptions()
	{
		int res = ExpectedExceptionsEx.division();
		System.out.println("Division is ->" + res);
		Assert.assertTrue(res == ExpectedExceptionsEx.divide);
	}
}
