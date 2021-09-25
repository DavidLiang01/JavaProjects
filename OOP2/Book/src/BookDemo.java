//---------------------------------------------------------------------------------------
//Assignment #1
//Question: PART 2
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------




//The purpose of this program is to allow the user to .............
import java.util.Scanner;
/**
 * The purpose of this program is to let the user enter books in his/her bookstore and to display/modify 
 * information of the books from the bookstore<br><br> 
 * COMP 249<br>
 * Assignment #1<br>
 * Due date: February 1, 2019<br>
 * @author David Liang (40092433)
 * 
 *
 */
public class BookDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		//Declaring variables
		int maxBooks;
		Book[] inventory; 
		int choice=1;  //initialized it because of error that program give at switch statement for choice
		final String password= "password";
		String user_password;
		int count=0;
		int count2=0;
		int num_books = 0;
		String title;
		String author;
		long ISBN;
		double price;
		boolean empty_arr=true;
		int book_num=0;
		int book_enter=0;
		int choice1=1;
		int book_index=0;
		boolean valid=true;
		int max=0;
		int maxBooks1=0;

		
		
		//Display welcome message 
		System.out.println("-------------------------------Hello! Welcome to the Store Book Tracker System-----------------------------------------------\n");
		
		//Ask user for maximum of books in the bookstore
		System.out.println("Please enter the maximum number of books that your bookstore can contain.");
		maxBooks= keyboard.nextInt();
		max=maxBooks;
		
		//Validate the user input of the maximum of books in the bookstore
		while (maxBooks<=0)
		{
			System.out.println("Error! Negative values and 0 are not allowed. Please re-enter the maximum number of books that your bookstore can contain.");
			maxBooks = keyboard.nextInt();
		}
		
		
		inventory= new Book[maxBooks];
		
		//Infinite loop that runs until the user choose to end the program
		do {
			//If user chose option 1 and was unable to enter the correct password for 12 times, then the system  will end
			if (count == 12)
			{
				System.out.println("\nProgram detected suspicious activities and will terminate immediately!");
				System.out.println("\n\n------------------------------End of Program. Goodbye!--------------------------------------");
				System.exit(0);
			}
			
			//Display the main menu for the options for every multiple of 3 unsuccessful password attempts
			if((count%3==0 || count2 %3==0)) 
			{
				System.out.println("\nWhat do you want to do?");
				System.out.println("       1. Enter new books (password required)");
				System.out.println("       2. Change information of a book (password required)");
				System.out.println("       3. Display all books by a specific author");
				System.out.println("       4. Display all books under a certain price");
				System.out.println("       5. Quit");
				
				//Ask user to enter choice and validate the input 
				do {
					System.out.println("\nPlease enter your choice >");
					choice= keyboard.nextInt();	
					
					if (choice<1 || choice >5)
					{
						System.out.println("Error! Invalid choice. Choice must be a number between 1 and 5");
					}
				}while(choice<1 || choice >5);
				
			}
			
			//The choices from 1 to 5 and the instructions of each of them 
			switch (choice) 
			{
			case 1:	
				//Check if the array is full
				if (maxBooks==0) 
				{
					System.out.println("Sorry, the maximum of book that can be entered in the bookstore is "+max+" books. Please choose another option.");
					break;
				}
				maxBooks1=maxBooks;
				
				//Ask user to input password and validate if it is the right one 
				do {
					System.out.println("\nPlease enter your password.");
					user_password = keyboard.next();
					if(!user_password.equals(password))
					{
						System.out.println("Error! Invalid password.");
						count++;
					}
				}while(!(user_password.equals(password)) && count%3!=0);
				
				//User input right password
				if (user_password.equals(password))
				{
					
					//Validate the user input
					do {
						maxBooks1=maxBooks;

						System.out.println("\nHow many books do you want to enter.");
						num_books= keyboard.nextInt();
						book_enter=num_books;
						
						//Display message if input is negative 
						if (num_books<0)
						{
							System.out.println("Error! Negative input is not allowed.");
						}
						
						//Display message if the number of books exceed the inventory array
						if (num_books>inventory.length)
						{
							System.out.println("Error! The book number exceed the spaces available.");
							System.out.println(inventory.length + " books are the maximum that can be entered in the bookstore.");
						}
						
						//Check if the number of books exceed the array
						maxBooks1= maxBooks1-book_enter;
						if (maxBooks1<0) 
						{
							System.out.println("Error! The maximum of book that can be entered in the bookstore is "+max+" books.");
						}
					}while(num_books<0 || num_books>inventory.length || maxBooks1<0);
					
					maxBooks= maxBooks-book_enter;
					
					//if user doesn't want to input number of books
					if (num_books==0)
					{
						break;
					}
				
					//Ask user for the information of the books and store them in the array
					for (int i=0; i<num_books;i++)
					{
						System.out.println("\nYou are now entering informations of book "+ (i+1)+ ".");
						System.out.println("\nPlease enter the title of book "+ (i+1)+".");
						keyboard.nextLine();
						title = keyboard.nextLine();
						System.out.println("\nPlease enter the author of book " + (i+1)+ ".");
						author = keyboard.nextLine();
						System.out.println("\nPlease enter the ISBN of book " + (i+1)+ ".");
						ISBN= keyboard.nextLong();		
						System.out.println("\nPlease enter the price of book " + (i+1)+ ".");
						price= keyboard.nextDouble();
						inventory[book_index] = new Book(title, author, ISBN, price);
						book_index++;
					}
				}
				break;
					
			case 2: 
				//Check if there is at a book object in the array
				empty_arr=true;
				for (int i=0; i<inventory.length;i++)
				{
					if (inventory[i]!=null)
					{
						empty_arr=false;
						break;
					}
				}
				
				//There is at least a book object in the array
				if (empty_arr== false)
				{
					//Ask user to input password and validate 
					do {
						System.out.println("\nPlease enter your password.");
						user_password = keyboard.next();
						
						if(!user_password.equals(password))
						{
							System.out.println("Error! Invalid password.");
							count2++;
						}				
					}while(!(user_password.equals(password)) && count2<3);			
					
					//When the password is valid, ask user for the book number 
					if(user_password.equals(password))   
					{
						//Ask book number
						do {
							choice1=1;
							System.out.println("\nPlease enter the book number that you wish to update.");
							book_num= keyboard.nextInt();
							
							if (book_num<0)
							{
								System.out.println("Error! Negative values are not allowed.");
							}
							
							if (book_num>=inventory.length)
							{
								System.out.println("Error! This book number doesn't exist.");
							}
							
							if(book_num>0 && book_num< inventory.length && inventory[book_num]==null)
							{
								System.out.println("Sorry, there is no book at this book number. Please, enter \"0\" to re-enter a book number or \"any number\" to go back to the main menu." );
							    choice1=keyboard.nextInt();
				
							}							
						}while (book_num<0 || book_num>= inventory.length || choice1==0);
						
						if (choice1 !=0 && inventory[book_num]==null)
					    {
					    	break;
					    }
						//Display book info
						do {
							System.out.println("\nBook #"+book_num);
							System.out.println("Title: "+ inventory[book_num].getTitle());
							System.out.println("Author: "+ inventory[book_num].getAuthor());
							System.out.println("ISBN: "+ inventory[book_num].getISBN());
							System.out.println("Price: $"+ inventory[book_num].getPrice());
							
							System.out.println("\nWhat information would you like to change?");
							System.out.println("    1. Author");
							System.out.println("    2. Title");
							System.out.println("    3. ISBN");
							System.out.println("    4. Price");
							System.out.println("    5. Quit");
							
							//Validate input
							do {
								System.out.println("\nEnter your choice >");
								choice = keyboard.nextInt();
								if (choice<=0 || choice >5)
								{
									System.out.println("Error! This choice is invalid. Please re-enter a choice from 1 to 5.");
								}
								
							}while (choice<=0 || choice>5);
							
							
							//Make the update depending on the choice
							switch (choice)
							{
							case 1:
								System.out.println("\nPlease enter the name of the author that you would like to change.");
								keyboard.nextLine();
								author = keyboard.nextLine();
								inventory[book_num].setAuthor(author);
								break;
							case 2:
								System.out.println("\nPlease enter the name of the title that you would like to change.");
								keyboard.nextLine();
								title = keyboard.nextLine();
								inventory[book_num].setTitle(title);
								break;
							case 3:
								System.out.println("\nPlease enter the ISBN that you would like to change.");
								ISBN = keyboard.nextLong();
								inventory[book_num].setISBN(ISBN);
								break;
							case 4:
								System.out.println("\nPlease enter the price that you would like to change.");
								price = keyboard.nextDouble();
								inventory[book_num].setPrice(price);
								break;
							case 5:
								break;
							}
							
							//Display updated info
							if(choice!=5)
							{
								System.out.println("\nUpdated information");
							}
						}while(choice!=5);
					}
				}			
				else
				{
					System.out.println("Sorry, there is no books in your bookstore. Please choose another option.");
				}					
				break;
		
			case 3:
				//Check if there is at a book object in the array
				for (int i=0; i<inventory.length;i++)
				{
					if (inventory[i]!=null)
					{
						empty_arr=false;
						break;
					}
				}  
				
				//Instructions to follow if there are books in the array
				if (empty_arr==false)
				{
					System.out.println("\nPlease enter a name of an author.");
					keyboard.nextLine();
					author= keyboard.nextLine();
					
					if(findBooksBy(inventory, author).equals(""))
					{
						System.out.println("Sorry, there are no books that have the author as "+author+" in the bookstore.");
					}
					else
					{
						System.out.println("\nThe books that have author as "+author +" are:");
						System.out.println(findBooksBy(inventory, author));
					}
				}
				//No book object in array
				else
				{
					System.out.println("There are no books in the bookstore. Please choose another option.");
				}
				break;
				
			case 4:
				//Check if there is at a book object in the array
				for (int i=0; i<inventory.length;i++)
				{
					if (inventory[i]!=null)
					{
						empty_arr=false;
						break;
					}
				}
				
				//There is a book object in the array
				if (empty_arr==false)
				{
					//user input of book price
					do {
						System.out.println("\nPlease enter the price for the books that are under this price."); 
						price= keyboard.nextDouble();
						
						//validate price
						if(price<0)
						{
							System.out.println("Error! Negative values are not allowed.");
						}
					}while(price<0);
					
					//No book found for the inputed price
					if (findCheaperThan(inventory, price).equals(""))
					{
						System.out.println("Sorry, there are no book(s) under "+price+"$ in the bookstore.");
					}
					//Find all books under the inputed price
					else
					{
						System.out.println("\nThe book(s) under "+ price + "$ are: ");
						System.out.println(findCheaperThan(inventory, price));						
					}
				}
				//There are no book objects in the array
				else
				{
					System.out.println("There are no books in the bookstore. Please choose another option.");
				}
				break;
				
			case 5:
				System.out.println("\n\n------------------------------End of Program. Goodbye!--------------------------------------");
				System.exit(0);
			}
		}while(valid);
	
	}
	

	/**
	 * Find books that are written by a specific author
	 * @param inventory Book array that stores every book objects
	 * @param name The name of the author of the book 
	 * @return Return the information about the book of the chosen author
	 */
	public static String findBooksBy(Book[] inventory, String name)
	{
		String info="";
		for (int i=0;i<inventory.length;i++)
		{
			if (inventory[i]!=null && inventory[i].getAuthor().equals(name) )
			{
				info= info + "\n-"+(inventory[i].toString());
			}
		}
		return info;
	}

	/**
	 * Find all books under a specific price in the inventory array
	 * @param inventory Book array that stores every book objects
	 * @param price The price of the book 
	 * @return Return information of all books under a specific price 
	 */
	//Static method to find books that are cheaper than a specific price
	public static String findCheaperThan(Book[] inventory, double price)
	{
		String info="";
		for (int i=0;i<inventory.length;i++)
		{
			if (inventory[i]!=null && inventory[i].getPrice()< price)
			{
				info= info+"\n-"+inventory[i].toString();
			}
		}
		return info;
	}

}
