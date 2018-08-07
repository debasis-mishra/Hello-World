package extentreportex;

import java.util.Properties;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Secur32;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;

public class UtilsEx {

	final Secur32 secur32 = (Secur32) Native.loadLibrary("secur32", Secur32.class, W32APIOptions.DEFAULT_OPTIONS);
	
	public String getLoginUserName()
	{
		return System.getProperty("user.name");
	}
	
	public String getHomeDir()
	{
		return System.getProperty("user.home");
	}
	
	public String getHostName() throws UnknownHostException
	{
		/*code snippet #36 - #37 for reading HostName*/
		InetAddress host = InetAddress.getLocalHost();
		return host.getHostName();
	}
	
	public String getEnvVarUser()
	{
		return System.getenv("USER");
	}
	
	
	public String getSystemProperties(String propertyName)
	{
		Properties props = System.getProperties();
		props.list(System.out);
		return props.getProperty(propertyName);
	}
	
	public String getCurrentUserName()
	{
		char[] userNameBuf  = new char[100];
		IntByReference size = new IntByReference(userNameBuf.length);
		boolean result = secur32.GetUserNameEx(Secur32.EXTENDED_NAME_FORMAT.NameSamCompatible, userNameBuf, size);
		
		if(!result)
			throw new IllegalStateException("Can't retrieve name of current login user");
		
		return new String(userNameBuf, 0, size.getValue());
	}
}
