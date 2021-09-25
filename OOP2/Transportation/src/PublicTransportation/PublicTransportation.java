//---------------------------------------------------------------------------------------
//Assignment #2
//Part1: PublicTransportation
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------

package PublicTransportation;


public class PublicTransportation {
	
	/**
	 * @author David Liang (40092433)<br>
	 * COMP 249<br>
	 * Assignment #1 Part1: PublicTransportation <br>
	 * Due date: February 20th, 2019
	 */
	
	protected double ticketPrice;  
	protected int numStops;        
	
	/**
	 * Default constructor 
	 */
	public PublicTransportation()
	{
		this.ticketPrice=5;
		this.numStops=10;
	}
	
	/**
	 * Parameterized constructor
	 * @param t The ticket price of the public transportation
	 * @param n The number of stops in the public transportation
	 */
	public PublicTransportation(double t, int n)
	{
		this.ticketPrice=t;
		this.numStops=n;
	}
	
	/**
	 * Copy constructor
	 * @param p1 The PublicTransportation constructor
	 */
	public PublicTransportation(PublicTransportation p1)
	{
		this.ticketPrice=p1.ticketPrice;
		this.numStops=p1.numStops;		
	}
	
	/**
	 * Mutator for the ticket price
	 * @param tp The ticket price 
	 */
	public void setTicketPrice(double tp)
	{
		this.ticketPrice=tp;
	}
	
	/**
	 * Mutator for the number of stops 
	 * @param s The number of stops
	 */
	public void setNumStops(int s)
	{
		this.numStops=s;
	}
	
	/**
	 * Accessor for the ticket price
	 * @return Return the ticket price
	 */
	public double getTicketPrice()
	{
		return ticketPrice;
	}
	
	/**
	 * Accessor for the number of stops
	 * @return Return the number of stops
	 */
	public int getNumStops()
	{
		return numStops;
	}
	
	/**
	 * Display the information (ticket price and number of stops) of the PublicTransportation object
	 */
	public String toString()
	{
		return ("The price of the ticket is "+ getTicketPrice() + "$ and there are "+ getNumStops()+" stations");
	}
	
	/**
	 * Determine if two objects are equal by comparing their attributes
	 * @param t1 The other PublicTransportation object
	 * @return Return if the two objects are the same
	 */
	
	/*
	 * Java allows to put a null object as a parameter of the equals method,
	 *  so adding the null condition will allow to check if the argument is a null object
	 *  and will return false
	 */
	public boolean equals(PublicTransportation t1)
	{
		if (t1 == null)
		{
			return false; 
		}
		else if (getClass()!= t1.getClass())
		{
			return false;
		}	
		else 
		{
			return (getNumStops()==t1.getNumStops() && getTicketPrice()==t1.getTicketPrice());
		}
	}

}
