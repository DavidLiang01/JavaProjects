//---------------------------------------------------------------------------------------
//Assignment #1
//Question: PART 1
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------

/**
 * The purpose of this part of the program is to create a book class that has the characteristic of 
 * a book such as the name of the author, title, ISBN and price. Also, this class contains many methods 
 * such as mutators/accessors, toString and others that allow the user to perform the tasks needed<br><br>
 * COMP 249<br>
 * Assignment #1<br>
 * Due date: February 1, 2019<b
 * @author David Liang (40092433)<br>
 *
 *
 */
/* The purpose of this part of the program is to create a book class that has the characteristic of 
 * a book such as the name of the author, title, ISBN and price. Also, this class contains many methods 
 * such as mutators/accessors, toString and others that allow the user to perform the tasks needed
  */

public class Book {
	
	//Declaring variables 
	private String title;
	private String author;
	private long ISBN;
	private double price;
	private static int count=0;
	
	/**
	 * This is a book constructor that has four attributes
	 * @param title the title of the book
	 * @param author the author of the book 
	 * @param ISBN  the ISBN of the book
	 * @param price the price of the book
	 */
	//Create constructor
	public Book(String title, String author, long ISBN, double price)
	{
		this.title= title;
		this.author= author;
		this.ISBN= ISBN;
		this.price=price;
		count++;
	}
	
	/**
	 * Mutator for the title of the book
	 * @param title The title of the book
	 */
	//mutator for title
	public void setTitle(String title)
	{
		this.title= title;
	}
	
	/**
	 * Mutator for the author of the book
	 * @param author The author of the book
	 */
	//mutator for author
	public void setAuthor(String author)
	{
		this.author= author;
	}
	
	/**
	 * Mutator for the ISBN of the book
	 * @param ISBN The ISBN of the book
	 */
	//mutator for ISBN
	public void setISBN(long ISBN)
	{
		this.ISBN= ISBN;
	}
	
	/**
	 * Mutator for the price of the book
	 * @param price The price of the book
	 */
	//mutator for price 
	public void setPrice(double price)
	{
		//validate the price  !!!!!!
		if (price<0)
		{
			System.out.println("Error! Cannot have negative value. Please re-enter the price");
		}
		else
		{
			this.price= price;
		}
	}
	
	/**
	 * Accessor for the title of the book
	 * @return Return the title of the book to the user
	 */
	//accessor for title
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * Accessor for the author of the book 
	 * @return Return the author of the book to the user
	 */
	//accessor for author
	public String getAuthor()
	{
		return this.author;
	}
	
	/**
	 * Accessor for the ISBN of the book
	 * @return Return the ISBN of the book to the user
	 */
	//accessor for ISBN
	public long getISBN()
	{
		return this.ISBN;
	}
	
	/**
	 * Accessor for the price of the book
	 * @return Return the price of the book to the user
	 */
	//accessor for price
	public double getPrice()
	{
		return this.price;
	}
	
	/**
	 * Display the information to the user 
	 */
	//Display data of the attributes
	public String toString()
	{
		return (this.author + " is the author of the book: "+ this.title + ", the ISBN of this book is: " + this.ISBN + " and it has a price tag of "+ this.price + "$.");
	}
	
	/**
	 * Determine the number of Book objects that have been created
	 * @return Return the number of Book objects
	 */
	//Determine the number of created book objects
	public int findNumberOfCreatedBooks()
	{
		return count;
	}
	
	/**
	 * Determine if two Book objects are the same by looking at the ISBN and the price
	 * @param anotherBook Take another Book object  
	 * @return Return a boolean whenever both objects are equal or not
	 */
	//Determine if two books are equal
	public boolean equals(Book anotherBook)
	{
		return ((this.ISBN==anotherBook.ISBN) && (this.price==anotherBook.price) );
	}
	


	
}
