package log4j2utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/*
 * https://howtodoinjava.com/log4j2/log4j-2-xml-configuration-example/
*/
public class Log4j2Ex {
	
	private static final Logger logger = LogManager.getLogger(Log4j2Ex.class.getName());
	
	public void performSomeTask()
	{
		logger.debug("Debug Message Logged !!!");
		logger.info("Info Message Logged !!!");
		logger.error("Error Message Logged !!!", new NullPointerException("Null Err"));
	}

}
