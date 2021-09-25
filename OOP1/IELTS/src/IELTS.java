//------------------------------------------------------------------------------------
//Assignment 2 IELTS
//Written by: David Liang (40092433)
//For COMP248 Section P -Fall 2018
//Submission date: October 12, 2018
//--------------------------------------------------------------------------------------
import java.util.Scanner;
public class IELTS {

	public static void main(String[] args) {
		/* The purpose of this program is to let the user know what are the language proficiency requirements for the 
           applicant at Concordia University and, also, the user can enter his/her scores for reading, writing, listening and speaking in order
           to know what type of admission he/she is in based on the applicant' scores.  
        */

		Scanner keyboard= new Scanner(System.in);
		
		// Declaring the variables
		double reading;                 //variable use to let the user input his/her reading score
		double writing;                 //variable use to let the user input his/her writing score 
		double listening;               //variable use to let the user input his/her listening score
		double speaking;                //variable use to let the user input his/her speaking score
		int count=0;                    //variable use to repeat something until a certain amount
		int userOption;                 //variable use to ask user which option to pick  
		double overall;                 //variable use to calculate the overall score of the user 
		int wholeNumber;                //variable use to round a number 
		double difference;              //variable use to see if rounding is necessary by calculating the difference
				
		//Displaying a welcome message 
		while(count<5) 
		{
			System.out.print("-------****");
			count=++count;
		}
		System.out.print("-------\n");
		System.out.println("       Welcome to Concordia Language Proficiency Evaluator!");
        System.out.println("               based on IELTS exam");
        count=0;
        while(count<5) 
		{
			System.out.print("-------****");
			count=++count;
		}
        System.out.print("-------\n");
		
		//Asking the user which option he/she wants
		System.out.println("Here are the available options:");
		System.out.println("       1 - Language Proficiency Requirements for the Applicant");
		System.out.println("       2 - Evaluation of your language proficiency\n");
		System.out.print("Please enter the digit corresponding to your case: ");
		userOption = keyboard.nextInt();
		System.out.println();
		
		//If user chose option 1
		if (userOption==1)
		{
			System.out.println("- The overall score of IELTS exam of applicants needs to be equal or above 6.5 and the scores\r\n" + 
					           "for writing and reading skills should not be below 6.0. If your overall score is 6, and your\r\n" + 
					           "reading and writing scores are at least 6, you will be eligible for conditional admission. So\r\n" + 
					           "you need to take an English course in the first semester. Otherwise you have to retake the IELTS\r\n" +
					           "exam.");
			System.out.println("Thanks for choosing Concordia.");
		}
		//If user chose option 2
		else
		{
			//Asking the user' scores: reading, listening, writing and speaking
			System.out.print("Please enter your listening score: ");
			listening = keyboard.nextDouble();
			System.out.println();
			
			System.out.print("Please enter your speaking score: ");
			speaking = keyboard.nextDouble();
			System.out.println();
			
			System.out.print("Please enter your reading score: ");
			reading = keyboard.nextDouble();
			System.out.println();
			
			System.out.print("Please enter your writing score: ");
			writing = keyboard.nextDouble();
			System.out.println();
			
			//Calculating the overall score
			overall= (listening + speaking + reading + writing)/4;
			
			//Identifying the decimal part
			wholeNumber =(int)overall;
			difference = overall - wholeNumber;
			
			//Rounding/classifying the overall score
			if (difference <0.25)
			{
				overall = wholeNumber;
			}
			else if (difference >= 0.25 && difference < 0.75)
			{
				overall = wholeNumber + 0.5;
			}
			else 
			{
				overall = wholeNumber + 1;
			}
			
			//Displaying outputs
			System.out.println("      Your overall score is: "+ overall);
			System.out.println("      Your reading score is: "+ reading);
			System.out.println("      Your writing score is: "+ writing + "\n");
			
			//Displaying type of admission for applicant based on scores
			if (overall >= 6.5 && reading >= 6 && writing >= 6)
			{
				System.out.println("Congratulations: You are eligible for Admission.");
			}
			else if ((overall >= 6.5 && (reading < 6 || writing < 6)) || (overall == 6 && reading >= 6 && writing >= 6))
			{
				System.out.println("You are eligible for Conditional Admission.");
			}
			else
			{
				System.out.println("Sorry, you have to retake the exam.");
			}
			//Closing message
			System.out.println("                  Thank you for choosing Concordia University.");
		}
		
		//Close the scanner
		keyboard.close();
		
		
		
		
	}

}
