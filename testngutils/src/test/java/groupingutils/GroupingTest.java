package groupingutils;

import org.testng.annotations.Test;

class GroupingTest1 {

	@Test(groups= {"SmokeTest","FunctionalTest"})
	public void verifyGrouping1()
	{
		System.out.println("Log in....");
	}
}
	
class GroupingTest2 {
	@Test(groups= {"FunctionalTest"})
	public void verifyGrouping2()
	{
		System.out.println("Compose mail....");
	}
}
