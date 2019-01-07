// -----------------------------------------------------
// Assignment 3
// COMP 249
// Written by: Konstantin Hristev, 40008099
// -----------------------------------------------------

/**
 *  This class is made in order to minimize the amount of times the PrintWriter is called
 *  in the BibCreator class. It allows us to store all the field contents of the articles
 *  in a Latex file (since we do not know how many articles there is per file).
 * @author Konstantin Hristev
 *
 */
public class Article {

	// Instance variables which store the contents of all the fields in an article
	private String authors;
	private String journal;
	private String title;
	private String year;
	private String volume;
	private String number;
	private String pages;
	private String keywords;
	private String doi;
	private String ISSN;
	private String month;
	private String ieeeFormat;
	private String acmFormat;
	private String njFormat;
	
	/**
	 * Default constructor
	 */
	public Article() {
		authors = null;
		journal = null;
		title = null;
		year = null;
		volume = null;
		number = null;
		pages = null;
		keywords = null;
		doi = null;
		ISSN = null;
		month = null;
		ieeeFormat = null;
		acmFormat = null;
		njFormat = null;
	}
	
	/**
	 * Parameterized constructor
	 * @param authors : The authors being stored in the Article object
	 * @param journal : The journal being stored in the Article object
	 * @param title : The title being stored in the Article object
	 * @param year : The year being stored in the Article object
	 * @param volume : The volume being stored in the Article object
	 * @param number : The number being stored in the Article object
	 * @param pages : The pages being stored in the Article object
	 * @param keywords : The keywords being stored in the Article object
	 * @param doi : The doi being stored in the Article object
	 * @param ISSN : The ISSN being stored in the Article object
	 * @param month : The month being stored in the Article object
	 * @param ieeeFormat : The contents formatted as IEEE being stored in the Article object
	 * @param acmFormat : The contents formatted as ACM being stored in the Article object
	 * @param njFormat : The contents formatted as NJ being stored in the Article object
	 */
	public Article(String authors, String journal, String title, String year, String volume, String number, String pages, String keywords, String doi, String ISSN, String month, String ieeeFormat, String acmFormat, String njFormat) {
		this.authors = authors;
		this.journal = journal;
		this.title = title;
		this.year = year;
		this.volume = volume;
		this.number = number;
		this.pages = pages;
		this.keywords = keywords;
		this.doi = doi;
		this.ISSN = ISSN;
		this.month = month;
		this.ieeeFormat = ieeeFormat;
		this.acmFormat = acmFormat;
		this.njFormat = njFormat;
	}
	
	/**
	 * Getter/Accessor method for authors
	 * @return : Returns the authors of the Article
	 */
	public String getAuthors() {
		return authors;
	}
	
	/**
	 * Getter/Accessor method for journal
	 * @return : Returns the journal of the Article
	 */
	public String getJournal() {
		return journal;
	}
	
	/**
	 * Getter/Accessor method for title
	 * @return : Returns the title of the Article
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Getter/Accessor method for year
	 * @return : Returns the year of the Article
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Getter/Accessor method for volume
	 * @return : Returns the volume of the Article
	 */
	public String getVolume() {
		return volume;
	}
	
	/**
	 * Getter/Accessor method for number
	 * @return : Returns the number of the Article
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Getter/Accessor method for pages
	 * @return : Returns the pages of the Article
	 */
	public String getPages() {
		return pages;
	}
	
	/**
	 * Getter/Accessor method for keywords
	 * @return : Returns the keywords of the Article
	 */
	public String getKeywords() {
		return keywords;
	}
	
	/**
	 * Getter/Accessor method for doi
	 * @return : Returns the doi of the Article
	 */
	public String getDOI() {
		return doi;
	}
	
	/**
	 * Getter/Accessor method for ISSN
	 * @return : Returns the ISSN of the Article
	 */
	public String getISSN() {
		return ISSN;
	}
	
	/**
	 * Getter/Accessor method for month
	 * @return : Returns the month of the Article
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * Getter/Accessor method for the String formatted as IEEE
	 * @return : Returns the String formatted as IEEE of the Article
	 */
	public String getIEEEFormat() {
		return ieeeFormat;
	}
	
	/**
	 * Getter/Accessor method for String formatted as ACM
	 * @return : Returns the String formatted as ACM of the Article
	 */
	public String getACMFormat() {
		return acmFormat;
	}
	
	/**
	 * Getter/Accessor method for String formatted as NJ
	 * @return : Returns the String formatted as NJ of the Article
	 */
	public String getNJFormat() {
		return njFormat;
	}
	
	/**
	 * Setter/Mutator method for authors
	 * @param authors : The authors to be stored in the Article object
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	/**
	 * Setter/Mutator method for journal
	 * @param authors : The journal to be stored in the Article object
	 */
	public void setJournal(String journal) {
		this.journal = journal;
	}
	
	/**
	 * Setter/Mutator method for title
	 * @param authors : The title to be stored in the Article object
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Setter/Mutator method for year
	 * @param authors : The year to be stored in the Article object
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Setter/Mutator method for volume
	 * @param authors : The volume to be stored in the Article object
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	/**
	 * Setter/Mutator method for number
	 * @param authors : The number to be stored in the Article object
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Setter/Mutator method for pages
	 * @param authors : The pages to be stored in the Article object
	 */
	public void setPages(String pages) {
		this.pages = pages;
	}
	
	/**
	 * Setter/Mutator method for keywords
	 * @param authors : The keywords to be stored in the Article object
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * Setter/Mutator method for doi
	 * @param authors : The doi to be stored in the Article object
	 */
	public void setDOI(String doi) {
		this.doi = doi;
	}
	
	/**
	 * Setter/Mutator method for ISSN
	 * @param authors : The ISSN to be stored in the Article object
	 */
	public void setISSN(String ISSN) {
		this.ISSN = ISSN;
	}
	
	/**
	 * Setter/Mutator method for month
	 * @param authors : The month to be stored in the Article object
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Setter/Mutator method for the IEEE formatted String
	 * @param authors : The IEEE formatted String to be stored in the Article object
	 */
	public void setIEEEFormat(String ieeeFormat) {
		this.ieeeFormat = ieeeFormat;
	}
	
	/**
	 * Setter/Mutator method for the ACM formatted String
	 * @param authors : The ACM formatted String to be stored in the Article object
	 */
	public void setACMFormat(String acmFormat) {
		this.acmFormat = acmFormat;
	}
	
	/**
	 * Setter/Mutator method for the NJ formatted String
	 * @param authors : The NJ formatted String to be stored in the Article object
	 */
	public void setNJFormat(String njFormat) {
		this.njFormat = njFormat;
	}	
}
