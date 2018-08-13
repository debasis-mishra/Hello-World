package filloex;

import java.util.Random;
import java.nio.charset.Charset;

public class FilloUtils {

	public static String genRandomData()
	{
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	 
	    return generatedString;
	}
}
