//-----------------------------------------------------------------------------------
//Assignment 3
//Part: Exception
//Written by: David Liang (40092433)
//-----------------------------------------------------------------------------------

/**
 * @author David Liang (40092433)<br>
 * COMP 249<br>
 * Assignment #3 Part: FileExistsExceptopn<br>
 * Due date: March 17th, 2019
 */

	public class FileExistsException extends Exception {
	
	/*
	 * The purpose of this program is to throw FileExistsException when there are  
	 * existing files with a given author name
	 */
	
	/**
	 * Default constructor of the exception 
	 */
	public FileExistsException()
	{
		super("Exception: There is already an existing file for that author. File will be renamed as BU, and older BU files will be deleted!");
	}
	
	
	/**
	 * Parameterized constructor of the exception
	 * @param s The desired message that is display when exception is called
	 */
	public FileExistsException(String s)
	{
		super(s);
	}

	
}
