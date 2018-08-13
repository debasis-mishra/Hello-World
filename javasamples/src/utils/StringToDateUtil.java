package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Java program to convert String to Date in Java. This example
 * use SimpleDateFormat for String to Date conversion, you can also
 * use JODA date and time API for that.
 *
 *
 */
public class StringToDateUtil{

	public static Date convertStringToDate(String str) throws ParseException{


		DateFormat formatter = null;
		Date convertedDate = null;
		if(str != null){
			formatter = new SimpleDateFormat("MM-dd-yyyy:HH:mm:SS");
			convertedDate = (Date) formatter.parse(str);
		}
		return convertedDate;
	}
}
