// -----------------------------------------------------
// Assignment 3
// COMP 249
// Written by: Konstantin Hristev, 40008099
// -----------------------------------------------------

/**
 * This class defines the custom exception which will be used in the BibCreator class.
 * It is thrown whenever the file is deemed to be invalid by the BufferedReader of the 
 * BibCreator class.
 * @author Konstantin Hristev
 *
 */
public class FileInvalidException extends Exception{

	/**
	 * Default constructor
	 */
	public FileInvalidException() {
		super("Error: Input file cannot be parsed due to missing information\r\n" 
				+ "(i.e. month={}, title={}, etc.) ");
	}
	
	/**
	 * Parameterized constructor
	 * @param message : The custom message passed by the programmer is stored in the Exception class constructor
	 */
	public FileInvalidException(String message) {
		super(message);
	}
}