//-------------------------------------------------------
//Assignment 2 Integer Division and Loop
//Written by: David Liang (40092433)
//COMP 248 Section P -Fall 2018
//Submission date: October 12, 2018
//-------------------------------------------------------
import java.util.Scanner;
public class IntegerDivisionAndLoop {

	public static void main(String[] args) {
		// The purpose of this program is to identify all divisors of a number when the user input a number 
		
		Scanner keyboard = new Scanner(System.in);
		
		//Display welcome message 
		System.out.println("         Welcome to our Calculation Program!");
		System.out.println("--------------------------------------------------------");
		
		//Declaring variables
		
	    int userDigits;                // the variable userDigits is use for inputting user's set of integers
		int sum = 0;                   // this variable is use to calculate the sum of the digits that the user inputed    
		int count =1;                  // this variable is to determine if the sum is a divisor or not 
		int digits;                    // this variable is use for adding all the digits into a sum 
 		String answer;                 // this variable is use to ask the user if he/she wants to continue the program by typing yes or no which are strings
		int lastUserDigits;            // this variable is use to store the input of the user and to display it after
		double number;                 // this variable is use as a number of a division 
		int wholeNum;                  // this variable is use to remove the decimals of a double 
		double decimals;               //this variable is use to show if there are any decimals part of a number
		double ZERO = 0;               // this variable is to see if the sum can be a divisor of the count, if not, then it wouldn't display the count
		double number1;               // this variable is use to remove the decimals part of the variable number
		
		//Do the process until the user say no
		do
		{
			//Ask user for inputs
			System.out.print("Enter a number with at most 7-digits: ");
			userDigits = keyboard.nextInt();			
			lastUserDigits = userDigits;
			
			//Sum of all digits
			while (userDigits > 0)
			{
				digits = userDigits % 10;
				sum = sum + digits;
				userDigits = userDigits/10; 
			}
			
			//Display user's inputs
			System.out.println("\nSum of the digits of " + lastUserDigits + " is: " + sum);
			
			System.out.println("\nThe divisors of " + sum + " are as follows:");
			
			//Identify the divisors
			do
			{
				number = ((double)sum)/count;
				number1 = number;
				wholeNum = (int)number1;
				decimals = number - wholeNum;
				if (decimals == ZERO)
				{
					System.out.print(count+" ");
				}				
				count = ++count;
			}
			while (count != (sum + 1));
			count = 1;
			sum = 0;
			
		//Ask the user if he/she wants to repeat the process	
		System.out.print("\n\nDo you want to try another number? (yes to repeat, and no to stop): ");
		answer = keyboard.next();
		System.out.println();
		}
		//If yes, repeat process
		while (answer.equals("yes"));
		
		//If no display closing message
		System.out.println("Thanks and have a great day!");
		
		//Closing the scanner 
		keyboard.close();

	}

}
