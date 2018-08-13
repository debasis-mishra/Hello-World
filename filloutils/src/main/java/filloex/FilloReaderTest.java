package filloex;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;

public class FilloReaderTest {

	
/* Came across below exception as the column name "year" is a keyword in Fillo. So, renamed column name
 * to serial_no and it started working
 * 
 * Exception in thread "main" com.codoid.products.exception.FilloException: Invalid Query - SELECT * FROM AIRLINES WHERE YEAR=1948
			at com.codoid.products.parser.SelectQueryParser.initializeQuery(SelectQueryParser.java:46)
			at com.codoid.products.fillo.Select.getRecordset(Select.java:44)
			at com.codoid.products.fillo.Connection.executeQuery(Connection.java:64)
			at filloex.FiloTest.excelData(FiloTest.java:23)
			at filloex.FiloTest.main(FiloTest.java:12)
*/

	public void excelReader() throws FilloException {
		String query = "Select * from Airlines where serial_no=1948";
		//String cond1 = "YEAR='joe'";
		Fillo fillo = new Fillo();
		Connection conn = fillo.getConnection("../filloutils/data/airline.xls");
		
		//Recordset recordset = conn.executeQuery(query).where(cond1);
		Recordset recordset = conn.executeQuery(query);
		
		String strr = "";
		
		while(recordset.next())
		{
			System.out.println("Info = " + recordset.getField(0).value());
			System.out.println("var1 = " + recordset.getField("var1"));
			System.out.println("var2 = " + recordset.getField("var2"));
			System.out.println("var3 = " + recordset.getField("var3"));
		}
		
		recordset.close();
		conn.close();		
	}
	
	public void excelReaderWithWhereMeth() throws FilloException
	{
		String query = "select * from Airlines";
		String cond1 = "var1 > 1";
		String cond2 = "var2 > 1";
		Fillo fillo = new Fillo();
		Connection conn = fillo.getConnection("../filloutils/data/airline.xls");
		Recordset recordset = conn.executeQuery(query).where(cond1).where(cond2);
		
		while(recordset.next())
		{
			System.out.println(recordset.getField("serial_no") + " " + recordset.getField("var1")
			+ " " + recordset.getField("var2"));
		}
		
		recordset.close();
		conn.close();
	}
	
}
