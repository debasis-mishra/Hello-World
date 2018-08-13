package log4jex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jEx {

	Logger logger = LogManager.getLogger();
	
	public void performSomeTask()
	{
		logger.debug("This a debug message");
		logger.info("This an info message");
		logger.error("This an error message");
		logger.warn("This a warning message");
		logger.fatal("This a afatal message");
	}
}
