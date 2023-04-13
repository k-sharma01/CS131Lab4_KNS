import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class has the ability to process a file of strings of a certain length
 * @author Kirin Sharma
 * CS131 Lab 4
 * @version 1.0
 */

public class FileProcessor {

	private String fileName; // holds name of the file
	private int stringLength;
	private ArrayList<String> stringList = new ArrayList<String>(); // an ArrayList of processed Strings
	private Scanner input; // Scanner obj will be used to process Strings
	private StringTooLongException stle = new StringTooLongException();
	
	/**
	 * Preferred constructor allows caller to pass in values
	 * @param fileName
	 * @param stringLength
	 */
	public FileProcessor(String fileName, int stringLength) 
	{
		setFileName(fileName);
		setStringLength(stringLength);
	}//end constructor
	
	/**
	 * Returns the amount of items in the ArrayList
	 * @return
	 */
	public int getArrayListSize() 
	{
		return stringList.size();
	}//end getArrayListSize
	
	/**
	 * Processes input from the user and appends to ArrayList if exception is not thrown
	 * @throws Exception 
	 */
	public void processFile()
	{
		try 
		{
			input = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
			return;
		}
		
		String currentLine;
		while(input.hasNextLine())
		{
			try
			{
			currentLine = input.nextLine();
			if (currentLine.length() > stringLength)
				throw stle;
			stringList.add(currentLine);
			}
			catch (StringTooLongException stle)
			{
				System.out.println(stle.getMessage());
			}
		} // end while
		
		
	}//end processFile
	
	/**
	 * Getter for fileName
	 * @return
	 */
	public String getFileName()
	{
		return fileName;
	} // end getFileName
	
	/**
	 * Setter for fileName
	 * @param name
	 */
	public void setFileName(String name)
	{
		fileName = name;
	} // end setFileName
	
	/**
	 * Getter for stringLength
	 * @return
	 */
	public int getStringLength()
	{
		return stringLength;
	} // end getStringLength
	
	/**
	 * Setter for stringLength
	 * @param L
	 */
	public void setStringLength(int L)
	{
		if (L < 5)
			stringLength = 5;
		else
			stringLength = L;
	} // end setStringLength
	
}//end class
