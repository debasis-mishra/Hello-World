package utils;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

/*This program searches for a URL in a text file and prses if found*/
public class SearchWordInTextFile {

	public static void main(String[] args) 
	{
		
	}
	
	public static String SearchForTextInFile() throws FileNotFoundException
	{
		String text  = "";
		Scanner txtscan = new Scanner(new File("../javasamples/resources/a.txt"));

		while(txtscan.hasNextLine()){
		    String str = txtscan.nextLine();
		    if(str.indexOf("http") != -1){
		    	text = str.substring(str.indexOf("http"));

		        txtscan.close();
		    }
		}
		txtscan.close();
		
		return text;
	}
}
