//--------------------------------------------------------------------
//Assignment 4 Crazy Nancy Game 
//Written by: David Liang (40092433)
//For COMP248 Section P -Fall 2018
//Submission date: November 30, 2018
//--------------------------------------------------------------------

/*The purpose of this class is to assign two random values for players 
 * to determine the order of the players' turn 
 */
public class Dice {

	//Declaring attributes
	private int value_die1;
	private int value_die2;
	
	//Declaring constructors
	public Dice()
	{
		value_die1=0;
		value_die2=0;
	}
	
	//Accessor for dice1
	public int getValue1()
	{
		return value_die1;
	}
	
	//Accessor for dice2
	public int getValue2()
	{
		return value_die2;
	}
	
	//Method that randomly gives values to the two dice
	public int rollDice()
	{
		int dice_sum;
		value_die1= (int) (Math.random()*6)+1;
		value_die2= (int) (Math.random()*6)+1;
		return dice_sum= value_die1 + value_die2;
	}
	
	//toString method that return data
	public String toString()
	{
		return ("Die 1: "+ value_die1+"  "+ "Die 2: "+ value_die2);
	}
	
}
