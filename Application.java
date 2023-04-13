/**
 * This class tests the FileProcessor class with different text files
 * @author Kirin Sharma
 * CS131 Lab 4
 * @version 1.0
 */

public class Application {
	
	public static void main(String[] args)
	{
		
		// Expected 19 out of the 20 strings in the text file to be processed
		System.out.println("\nTesting the file BadString.txt:");
		FileProcessor fpOne = new FileProcessor("BadString.txt", 10);
		fpOne.processFile();
		System.out.println(fpOne.getArrayListSize());
		
		// Expected 10 out of the 10 strings in the text file to be processed
		System.out.println("\nTesting the file GoodString.txt:");
		FileProcessor fpTwo = new FileProcessor("GoodString.txt", 10);
		fpTwo.processFile();
		System.out.println(fpTwo.getArrayListSize());
		
		// Testing output if there is a bad file name
		System.out.println("\nTesting the non-existent file DNE.txt:");
		FileProcessor fpThree = new FileProcessor("DNE.txt", 5);
		fpThree.processFile();
		System.out.println(fpThree.getArrayListSize());

		
	} // end main
	
} // end class
