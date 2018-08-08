package dataproviderutils;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest2 {

	/*If data provider is defined in same class as that of test method, use below syntax*/
	@DataProvider(name="getData")
	public Object[][] dataSource()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "User1";
		data[0][1] = "Pwd1";
		
		data[1][0] = "User2";
		data[1][1] = "Pwd2";
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void loginTest(String uname, String passwd)
	{
		System.out.println(uname + "\t" + passwd);
	}
}
