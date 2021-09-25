//------------------------------------------------------------------------------
//Assignment 1
//Written by: David Liang (40092433)
//COMP 248 Section P  -Fall 2018
//-----------------------------------------------------------------------------
import java.util.Scanner;
public class BodyMassIndex {
	
	/* This program will calculate the Body Mass Index(BMI) of an individual by asking 
    the user's height in meters and weight in kilograms 
    */ 
	
	public static void main(String[] args) 
	{
		
		//let's declare the scanner 
		Scanner measures = new Scanner(System.in);
		
		//Display welcome message 
		System.out.println("Welcome to the Body Mass Index Calculator\n");
		
		//Ask user for height
		System.out.println("Please enter your height in meters:");
		
		//Read user's height 
		double height = measures.nextDouble();
		
		//Ask for user's weight 
		System.out.println("Please enter your weight in kilograms:");
		
		// read user's weight
		double weight = measures.nextDouble();
			
		// Calculate BMI
		double BMI = (weight/((height)*(height)));		
		System.out.println("**********BMI Calculator**********");
		
		// display user's inputs: height, weight and system calculate BMI based on user's inputs
		System.out.println("Your height is:" + "         " + height+" m");
		System.out.println("Your weight is:" + "         " + weight+" kg"+"\n");
		System.out.println("Your BMI is:" + "            " + BMI);
	    System.out.println("**********Thanks for using the bestest BMI calculator ever**********");
	    
		// Closing the scanner 
		measures.close();
	
		
		
	}

}
