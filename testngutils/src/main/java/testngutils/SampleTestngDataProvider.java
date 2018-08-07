package testngutils;

import org.testng.annotations.DataProvider;

public class SampleTestngDataProvider {

	@DataProvider(name = "Authentication")
	public Object[][] credentials()
	{
		return new Object[][] {
			{"testuser_1", "test123"}, {"testuser_2", "India123"}, {"testuser_3", "Password1"}
			};
	}
}
