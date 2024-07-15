import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

/**
 *	File Utilities for reading and writing
 * 
 *	@author	Ronith Vinod Chikkaballapur
 *	@since August 24, 2023
 */


/*
When ever you start out with forward slash and two asterisk is considered javadoc
Whenever you start a program - use java doc notation and put in comments
 - Give comments
 - Overview
 - Author
 - Since what date

The symbols, then a tab after the asterisk

 - For every paramter - you need to make a new @param
- Also for every return, same thing
- Camel case - openToRead
- Note - the java.util.Scanner is what we're returning and we're telling it where to find it



- You can use imports so you don't have to specify where PrintWriter is
* Note - in terminal - to compile file - you can do javac * OR javac File.java
*/

//compiling jar files:  javac -cp ".;mvAcm.jar" *.java
//Don't need to do double quotes around in linux
//Do: java -cp ".;mvAcm.jar" FirstAssignment
// ^^ to actually run the file FirstAssignment


// Mr. Greenstein isn't picky about the way we put the braces (below/on side)

public class FileUtils
{
	/**
	 * Opens a file to read using the Scanner class.
	 * @param fileName	name of the file to open
	 * @return			the Scanner object to the file
	 */
	public static java.util.Scanner openToRead(String fileName)
	{
		java.util.Scanner input = null;
		try {
			input = new java.util.Scanner(new java.io.File(fileName));
		}
		catch(java.io.FileNotFoundException e){
			//can name exception e - or anything you want
			//System.err prints it out to the a special place - the log of errors
			System.err.println("ERROR: Cannot open " + fileName + 
								" for reading.");
			System.exit(-1);
			//this number is any integer number???
			// 404 File Not Found - they put that number in - only means
			// something to the programmers - programmers know exactly where this is
			
			
		}
		return input;
	}
	
	/**
	 * Opens a file to write using the PrintWriter class.
	 * @param fileName	Name of the file to open
	 * @return 			The PrintWriter object to the file
	 * 
	 */
	 
	 public static PrintWriter openToWrite(String fileName){
		 PrintWriter output = null;
		 try {
			 output = new PrintWriter(new File(fileName));
		 }
		 catch(FileNotFoundException e){
			System.err.println("ERROR: Cannot open " + fileName + 
								" for writing");
								
			System.exit(-1);
		 
		 }
		 return output;
		 
	 }
	
}






