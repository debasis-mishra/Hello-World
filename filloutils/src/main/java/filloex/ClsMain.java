package filloex;

import com.codoid.products.exception.FilloException;

public class ClsMain {

/*	Got below exception because excel file was open when new record was inserted. Closed excel 
 *  sheet and it started working....
 *  
 * com.codoid.products.exception.FilloException: Insert query cannot be proccesed, if File is already opened. File Path-../filloutils/data/airline.xls
	at com.codoid.products.fillo.InsertExcelUtil.saveWorkBook(InsertExcelUtil.java:134)
	at com.codoid.products.fillo.InsertExcelUtil.runInsertQuery(InsertExcelUtil.java:105)
	at com.codoid.products.fillo.Insert.executeInsert(Insert.java:48)
	at com.codoid.products.fillo.Connection.executeUpdate(Connection.java:97)
	at filloex.FilloWriterTest.insertexcelRecord(FilloWriterTest.java:14)
	at filloex.ClsMain.main(ClsMain.java:18)*/
	
	public static void main(String[] args)
	{
		FilloReaderTest reader = new FilloReaderTest();
		FilloWriterTest writer = new FilloWriterTest();
		
		try
		{
			System.out.println("Original excel data.....");
			reader.excelReader();
			
			System.out.println("Insert new Pilot...");
			int status = writer.insertexcelRecord();
			
			if(status == 0)
				System.out.println("New pilot inserted successfully!");
			
			System.out.println("All Pilots after inserting new Pilot.....");
			reader.excelReader();
			
			System.out.println("Multiple conditions in query -> Where method");
			reader.excelReaderWithWhereMeth();
			
			
		}
		catch(FilloException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
