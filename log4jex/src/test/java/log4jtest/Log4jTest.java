package log4jtest;

import log4jex.Log4jEx;

import org.junit.Assert;
import org.junit.Test;


/*
 * For further info read below article
 * https://dzone.com/articles/log4j-2-configuration-using-properties-file
*/	
public class Log4jTest {

	@Test
	public void testPerformSomeTask()
	{
		Log4jEx log4j = new Log4jEx();
		log4j.performSomeTask();
	}
}
