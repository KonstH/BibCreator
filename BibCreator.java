// -----------------------------------------------------
// Assignment 3
// COMP 249
// Written by: Konstantin Hristev, 40008099
//
// Note: I encountered a problem while trying to delete the invalid files. I tried closing the stream before calling the .delete() method,
// and made sure that all files were not opened anywhere else on the computer before deleting.
// -----------------------------------------------------

// importing needed libraries for the function of the program
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 	This is the class which holds the main function of the BibCreator program. The program reads through 10 .bib files and extracts the information within.
 *	The information is then manipulated and formatted according to 3 conventions: IEEE, ACM and NJ. After properly having formatted the information from the .bib files,
 *	the BibCreator program creates 3 new files for each .bib file and writes the information in them respectively. However, this only happens if the program has judged 
 *	the .bib files to be valid (meaning there are no empty fields), in which case they are deleted.
 *
 * @author Konstantin Hristev
 *	
 */
public class BibCreator {

	public static void main(String[] args) {
		
		// Prints welcome message
		System.out.println("Welcome to BibCreator!\n");
		
		// The streams are created and set to null to be accessible outside the try blocks where they are opened
		Scanner sc = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		// The names of the original files are stored in an array of Strings and corresponding File objects are created
		// for each file and stored in a File array. Files are then opened and if not found, appropriate message is printed.
		for(int i=0; i<amountOfFiles; i++) {
			
			originalFileName[i] = "Latex"+(i+1)+".bib";
			originalFile[i] = new File(originalFileName[i]);
		
			try {
				sc = new Scanner(new FileInputStream(originalFile[i]));
				sc.close();
			}
			
			catch(FileNotFoundException e) {							   
				System.out.println("Could not open input file " + originalFileName[i] + " for reading.\n\n"
									+ "Please check if file exists! Program will terminate after closing any opened files.");
				System.exit(0);	
				sc.close();
				
			} 
		
		}	// end of for loop
		
		// The names of the formatted files are created and stored in an array of Strings and corresponding File objects are created
		// for each file and stored in a File array. The files are then attempted to be opened and if they cannot be created, an 
		// appropriate message is printed and the faulty files are deleted using deleteFile() method.
		for(int i=0; i<amountOfFiles; i++) {
			
			// The formatted files are assigned appropriate names and these are stored in String arrays depending on their format style
			ieeeFileName[i] = "IEEE"+(i+1)+".json";
			acmFileName[i] = "ACM"+(i+1)+".json";
			njFileName[i] = "NJ"+(i+1)+".json";
			
			// The Files are created, assigned the names we created above and stored in File arrays depending on their format style
			ieeeFile[i] = new File (ieeeFileName[i]);
			acmFile[i] = new File (acmFileName[i]);
			njFile[i] = new File (njFileName[i]);
		
			
			// Creating the IEEE files
			try {
				pw = new PrintWriter(new FileOutputStream(ieeeFile[i]));
				pw.close();
			}
			
			catch(FileNotFoundException e) {							   
				System.out.println("Could not create/open input file " + ieeeFileName + ".\n\n"
									+ "All created files will be deleted, and program will terminate.");
				
				pw.close();
				
				// loops as many times as there were files successfully created and deletes them using deleteFile() function
				for(int j=0; j<i; j++)
					deleteFiles(i);
				
				System.exit(0);	
				
			}
			
			
			// Creating the ACM files
			try {
				pw = new PrintWriter(new FileOutputStream(acmFile[i]));
				pw.close();
			}
			
			catch(FileNotFoundException e) {							   
				System.out.println("Could not create/open input file " + acmFileName + ".\n\n"
									+ "All created files will be deleted, and program will terminate.");
				
				pw.close();
				
				// loops as many times as there were files successfully created and deletes them using deleteFile() function
				for(int j=0; j<i; j++)
					deleteFiles(i);
				
				System.exit(0);	
			}
			
						
			// Creating the NJ files
			try {
				pw = new PrintWriter(new FileOutputStream(njFile[i]));
				pw.close();
			}
			
			catch(FileNotFoundException e) {							   
				System.out.println("Could not create/open input file " + njFileName + ".\n\n"
									+ "All created files will be deleted, and program will terminate.");
				
				pw.close();	
				
				// loops as many times as there were files successfully created and deletes them using deleteFile() function
				for(int j=0; j<=i; j++)
					deleteFiles(i);
				
				System.exit(0);
				
			}
		
		}	// end of for loop
		
		
		// Printing the formatted articles in the json files using methods declared below
		for(int i=0; i<originalFile.length; i++) {
			processFilesForValidation(i);
		}
		
		System.out.println("A total of " + invalidFiles + " files were invalid, and could not be processed. All other " + (10-invalidFiles)
				+ " \"Valid\" files have been created.");
		
		// Asking user which file they would like to open and display its contents if it exists
		System.out.print("\nPlease enter the name of one of the files that you need to review: ");
		Scanner user_input = new Scanner (System.in);
		String fileName = user_input.nextLine();
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			
			System.out.println("Here are the contents of the successfully created JSON File: " + fileName);
			String nextLine = br.readLine();
			
			while(nextLine!=null) {
				System.out.println(nextLine);
				nextLine = br.readLine();
			}
			
		System.out.println("Goodbye! Hope you have enjoyed creating the needed files using BibCreator.");
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Could not open input file. File does not exist; possibly it could not be created!\n");
			System.out.println("However, you will be allowed another chance to enter another file name.");
			System.out.print("Please enter the name of one of the files that you need to review: ");
			fileName = user_input.nextLine();
			
			try {
				br = new BufferedReader(new FileReader(fileName));
				System.out.println("Here are the contents of the successfully created JSON File: " + fileName);
				String nextLine = br.readLine();
				
				while(nextLine!=null) {
					System.out.println(nextLine);
					nextLine = br.readLine();
				}
				
			} 
			catch (FileNotFoundException ee) {
				System.out.println("\nCould not open input file again! Either file does not exist or could not be created.");
				System.out.println("Sorry I am unable to display your desired files! Program will exit!");
				System.exit(0);
			}
			
			catch(IOException ee) {
				System.out.println("An error has occured while closing the file. ");
				System.out.println("Program will exit....");
				System.exit(0);	
			}
		}
		
		catch(IOException e) {
			System.out.println("An error has occured while closing the file. ");
			System.out.println("Program will exit....");
			System.exit(0);	
		}
		
		finally{
			user_input.close();
		}

		
		
	
	}	// end of main() method
	
	// Declaration of variables. They are static to be accessible by the main() method.	
	static int amountOfFiles = 10;	// variable which stores total amount of files. Helps making code more understandable
	static String [] originalFileName = new String [10];	// array which stores names of the original files as Strings
	static String [] ieeeFileName = new String [10];	// array which stores names of the IEEE files as Strings
	static String [] acmFileName = new String [10];		// array which stores names of the ACM files as Strings
	static String [] njFileName = new String [10];		// array which stores names of the NJ files as Strings
	static File [] originalFile = new File [10];	// array which stores the original files as File objects
	static File [] ieeeFile = new File [10];	// array which stores files formated with IEEE as File objects
	static File [] acmFile = new File [10];	// array which stores files formated with ACM as File objects
	static File [] njFile = new File [10];		// array which stores files formated with NJ as File objects
	
	// we will store the articles in an arraylist, because we do not know how many articles are in each file and the array size needs to adjust dynamically
	static ArrayList <Article> article = new ArrayList<Article>();	
	
	static int articleNum = 0;	//	counts the number of articles in each file
	static int invalidFiles = 0;
	

	/**
	 * This method deletes an existing IEEE, ACM or NJ file when it is called 
	 * @param i
	 * : The index of the files that needs to be deleted in the array
	 */
	public static void deleteFiles(int i) {
		
		if(ieeeFile[i].exists()) {
			ieeeFile[i].delete();			
		}
		if(acmFile[i].exists()) {
			acmFile[i].delete();
		}
		
		if(njFile[i].exists()) {
			njFile[i].delete();
		}
		
	}	// end of deleteFile() method
	
	/**
	 * 
	 * @param i
	 * : Indicates the index of the .bib File which needs to be read and printed to the .json files
	 */
	public static void processFilesForValidation(int i) {
		
		Article tmpArticle = new Article();	// Article object declared to be populated below and inserted in Array List
		BufferedReader br = null;
		PrintWriter pw = null;
		String nextLine = null;	// will store the line being read by the buffered reader
		String field = null;	// represents the field of the article 
		
		article.add(articleNum, tmpArticle);	// we insert the above article object in the articleNum index
		
		
		try {
			br = new BufferedReader(new FileReader(originalFile[i]));
								
			while ((nextLine = br.readLine()) != null) {
				
				// calls method validField() which checks if the field stored in nextLine is valid and if it should be stored
				if (validField(nextLine).equals("validWrite")) {
					field = nextLine.substring(0, nextLine.indexOf('='));
					
					// Switch statement which evaluates the field being read and stores its contents in the respective instance variable of the Article object
					switch(field) {
						
						case "author": article.get(articleNum).setAuthors(getContent(nextLine));
						break;
						
						case "journal": article.get(articleNum).setJournal(getContent(nextLine));				
						break;
						
						case "title": article.get(articleNum).setTitle(getContent(nextLine));			  
						break;
						
						case "year": article.get(articleNum).setYear(getContent(nextLine));			
						break;
						
						case "volume": article.get(articleNum).setVolume(getContent(nextLine));
						break;
						
						case "number":	article.get(articleNum).setNumber(getContent(nextLine));
						break;
						
						case "pages": article.get(articleNum).setPages(getContent(nextLine));  
						break;
						
						case "keyword": article.get(articleNum).setKeywords(getContent(nextLine));
						break;
						
						case "doi": article.get(articleNum).setDOI(getContent(nextLine));
						break;
						
						case "ISSN": article.get(articleNum).setISSN(getContent(nextLine));
						break;
						
						case "month": article.get(articleNum).setMonth(getContent(nextLine));	
						break;
						
						default: 
						break;
					}
										
				}	// end of first if statement
				
				// enters if it is the end of an article
				else if (nextLine.equals("}")) {
					
					// storing all properly formatted fields into respective variables
					String ieeeFormat = ieeeFormatter(article.get(articleNum));
					String acmFormat = acmFormatter(article.get(articleNum));
					String njFormat = njFormatter(article.get(articleNum));
					
					// Storing the above strings into the article object variables
					article.get(articleNum).setIEEEFormat(ieeeFormat);
					article.get(articleNum).setACMFormat(acmFormat);
					article.get(articleNum).setNJFormat(njFormat);
					
					articleNum++;	// increment article number to create a new article object in the article array if another article is found by reader
					tmpArticle = new Article();		// Article object is set to null to be populated with the new values read in the next loop iteration
					article.add(articleNum, tmpArticle);	// we insert the above Article object in the articleNum index
				}
				
				// enters if a field is detected to be invalid
				else {
					
					
					if(nextLine.indexOf('=') != -1 ) {
						invalidFiles++;
						field = nextLine.substring(0, nextLine.indexOf('='));	// stores the field which was found to be empty (invalid)
						br.close();
						throw new FileInvalidException();
					}
					
					
				}
				
					
			}	// end of while loop	
		}	// end of try-block
		
		catch (FileInvalidException e) {
			System.out.println("Error: Detected Empty Field!\n"
								+ "============================\n\n"
								+ "Problem detected with input file " + originalFileName[i]
								+ " \nFile is Invalid: Field \"" + field + "\" is Empty. Processing stopped at this point."
								+ " Other Empty fields may be present as well!\n\n");
			deleteFiles(i);
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Could not create/open input file.\n\nProgram will terminate.");
			System.exit(0);
		}
		
		catch (IOException e) {
			System.out.println("An error has occured while closing the file. ");
			System.out.println("Program will exit....");
			System.exit(0);
		}
		
		// Printing the IEEE formats in the appropriate .json files
		try {
			pw = new PrintWriter(new FileOutputStream(ieeeFile[i], true));
			
			for(int j=0; j<article.size(); j++) {
				if (article.get(j).getIEEEFormat() != null) {
				pw.println(article.get(j).getIEEEFormat());
				pw.println();
				}
			}
			
			pw.close();
			}
		
		catch(FileNotFoundException e) {
		
			System.out.println("Could not create/open input file. " + ieeeFile[i] + "\n\nProgram will terminate.");
			System.exit(0);
						
		}
		
		// Printing the ACM formats in the appropriate .json files
		try {
			pw = new PrintWriter(new FileOutputStream(acmFile[i], true));
			
			for(int j=0; j<article.size(); j++) {
				if (article.get(j).getACMFormat() != null) {
				pw.println(article.get(j).getACMFormat());
				pw.println();
				}
			}
			
			pw.close();
			}
		
		catch(FileNotFoundException e) {
		
			System.out.println("Could not create/open input file. " + acmFile[i] + "\n\nProgram will terminate.");
			System.exit(0);
						
		}
		
		// Printing the NJ formats in the appropriate .json files
		try {
			pw = new PrintWriter(new FileOutputStream(njFile[i], true));
			
			for(int j=0; j<article.size(); j++) {
				if (article.get(j).getNJFormat() != null) {
				pw.println(article.get(j).getNJFormat());
				pw.println();
				}
			}
			
			pw.close();
			}
		
		catch(FileNotFoundException e) {
		
			System.out.println("Could not create/open input file. " + njFile[i] + "\n\nProgram will terminate.");
			System.exit(0);
						
		}	
		
	}	// end of processFilesForValidation() method
	

	/**
	 * This method checks if the string passed corresponds to one of 3 cases. Either it is
	 * valid but needs to be skipped, is valid and needs to be stored or is invalid.
	 * @param s
	 * : The string read by the BufferedReader that needs to be evaluated
	 * @return
	 * : String which dictates what type of field the parameter corresponds to
	 */
	public static String validField(String s) {
		
		int left_bracket = s.indexOf('{');
		int right_bracket = s.indexOf('}');
		
		if ((right_bracket - left_bracket == 1)) {
			return "invalid"; // means file is invalid
		}
		
		else if ((left_bracket != -1 && right_bracket == -1) || (left_bracket == -1 && right_bracket == -1)) {
			return "validNoWrite";	// means line is valid, but shouldn't be written
		}
		else 
			return "validWrite"; // means line is valid and should be written to file
	}
	
	/**
	 * This method returns the content stored between the curly braces of the field string passed
	 * @param s
	 * : The string read by the BufferedReader that needs to be evaluated
	 * @return
	 * : Returns the content between the curly braces
	 */
	public static String getContent(String s) {
		
		int left_bracket = s.indexOf('{');
		int right_bracket = s.indexOf('}');
		
		return s.substring(left_bracket+1, right_bracket);
		
	}
	
	/**
	 * This method manipulates the contents of the instance varibales of the article passed and formats them
	 * accoring to IEEE convention.
	 * @param article
	 * : Article object that needs its contents manipulated to IEEE convention
	 * @return
	 * : Returns the properly formatted contents as a String 
	 */
	public static String ieeeFormatter(Article article) {
		
		// Formatting the authors accoring to IEEE convention using split() function
		String authors = article.getAuthors();
		String newAuthors = "";
		String delimiter = " and ";
		String [] authorsSplit = authors.split(delimiter);
		
		for(int i=0; i<authorsSplit.length; i++) {
			if (i != authorsSplit.length-1)
				newAuthors += authorsSplit[i] + ", ";
			else
				newAuthors += authorsSplit[i] + ". ";
		}
		
		return newAuthors + "\"" + article.getTitle() + "\", " + article.getJournal() + ", vol. " + article.getVolume()
			   + ", no. " + article.getNumber() + ", p. " + article.getPages() + ", " + article.getMonth()
			   + " " + article.getYear() + ".";	
	}
	
	/**
	 * This method manipulates the contents of the instance varibales of the article passed and formats them
	 * accoring to ACM convention.
	 * @param article
	 * : Article object that needs its contents manipulated to ACM convention
	 * @return
	 * : Returns the properly formatted contents as a String 
	 */
	public static String acmFormatter(Article article) {
		
		// Formatting the authors accoring to ACM convention using split() function
		String authors = article.getAuthors();
		String newAuthors = "";
		String delimiter = " and ";
		String [] authorsSplit = authors.split(delimiter);
		
		for(int i=0; i<authorsSplit.length; i++) {
			if (i==0)
				newAuthors += authorsSplit[i] + " et al. ";
		}
		
		return "[" + (articleNum+1) + "]\t" + newAuthors + article.getYear() + ". " + article.getTitle() + ". " 
			   + article.getJournal() + ". " + article.getVolume() + ", " + article.getNumber() + " (" + article.getYear() + "), " 
			   + article.getPages() + ". DOI:https://doi.org/" + article.getDOI() + ".";	
	}
	
	/**
	 * This method manipulates the contents of the instance varibales of the article passed and formats them
	 * accoring to NJ convention.
	 * @param article
	 * : Article object that needs its contents manipulated to NJ convention
	 * @return
	 * : Returns the properly formatted contents as a String 
	 */
	public static String njFormatter(Article article) {
		
		// Formatting the authors accoring to ACM convention using split() function
		String authors = article.getAuthors();
		String newAuthors = "";
		String delimiter = " and ";
		String [] authorsSplit = authors.split(delimiter);
		
		for(int i=0; i<authorsSplit.length; i++) {
			if (i != authorsSplit.length-1)
				newAuthors += authorsSplit[i] + " & ";
			else
				newAuthors += authorsSplit[i] + ". ";
		}
		
		return newAuthors + article.getTitle() + ". " + article.getJournal() + ". " + article.getVolume()
			   + ", " + article.getPages() + "(" + article.getYear() + ").";
	}
		
}	// end of BibCreator class
