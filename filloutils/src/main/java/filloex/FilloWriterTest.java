package filloex;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Connection;
import com.codoid.products.exception.FilloException;

public class FilloWriterTest {

	public int insertexcelRecord() throws FilloException
	{
		Fillo fillo = new Fillo();
		Connection conn = fillo.getConnection("../filloutils/data/airline.xls");
		int cnt = conn.executeUpdate("insert into Pilots(userid,pass) values('" + 
				FilloUtils.genRandomData() + "','" + FilloUtils.genRandomData() + "')");
		
		return cnt;
	}
}
