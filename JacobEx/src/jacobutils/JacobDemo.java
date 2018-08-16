package jacobutils;

import java.io.File;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;


/*
 * Access below link for further readings
 * https://www.joecolantonio.com/selenium-autoit-how-to-automate-non-browser-based-functionality/
*/
public class JacobDemo {

	public static String jvmBitVersion()
	{
		return System.getProperty("sun.arch.data.model");
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		String jacobDLLversionToUse="";
		
		if(jvmBitVersion().contains("64"))
		{
			jacobDLLversionToUse = "jacob-1.19-x64.dll";
		}
		else
		{
			jacobDLLversionToUse = "jacob-1.19-x86.dll";
		}
		
		File file = new File("lib", jacobDLLversionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		
		AutoItX x = new AutoItX();
		
		//launches an exe
		x.run("calc.exe");
		
		//gives focus to a window
		x.winActivate("Calculator");
		
		/*Sends a mouse click command to a given control.
		Defn: ControlClick ( "title", "text", controlID [, button = "left" [, clicks = 1 [, x [, y]]]] )*/
		
		Thread.sleep(2000);
		x.controlClick("Calculator", "", "133"); //Enter 3
		Thread.sleep(1000);
		
		x.controlClick("Calculator", "", "93"); //Enter +
		Thread.sleep(1000);
		
		x.controlClick("Calculator", "", "133") ; //Enter 3
		Thread.sleep(1000);
		
		x.controlClick("Calculator", "", "121") ; //Enter =
	}
}
