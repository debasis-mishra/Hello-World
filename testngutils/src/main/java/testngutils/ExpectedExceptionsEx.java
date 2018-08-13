package testngutils;

public class ExpectedExceptionsEx {

	public static int num1= 10, num2 = 0, divide;
	public static int division() throws ArithmeticException
	{
		divide  = num1 /num2;
		return divide;
	}
}
