//---------------------------------------------------------------------------------------
//Assignment #2
//Part2: Ferry2
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------
package Part2_Boat;

import Part2_PublicTransportation.PublicTransportation2;

public class Ferry2 extends PublicTransportation2{
	/**
	 * @author David Liang (40092433)<br>
	 * COMP 249<br>
	 * Assignment #1 Part2: Ferry2 <br>
	 * Due date: February 20th, 2019
	 */

	private int buildYear;
	private String shipName;

	/**
	 * Default constructor
	 */
	public Ferry2()
	{
		super();
		this.buildYear=2019;
		this.shipName="No name";
	}
	
	/** 
	 * Parameterized constructor
	 * @param t The ticket price
	 * @param n The number of stops 
	 * @param y The year when the ferry was built
	 * @param name The name of the ferry
	 */
	public Ferry2(double t, int n,int y, String name)
	{
		super(t,n);
		this.buildYear=y;
		this.shipName=name;
	}
	
	/** 
	 * Copy constructor	
	 * @param f1 The Ferry constructor that is being copied
	 */
	public Ferry2 (Ferry2 f1)
	{
		super(f1);
		this.buildYear=f1.buildYear;
		this.shipName=f1.shipName;
	}

	/**
	 * Mutator for the build year
	 * @param y The desired build year 
	 */
	public void setBuildYear(int y)
	{
		this.buildYear=y;
	}
		
	/**
	 * Mutator for the ship name
	 * @param n The name of the ship
	 */
	public void setShipName(String n)
	{
		this.shipName=n;
	}
		
	/**
	 * Accessor for the build yeat
	 * @return Return the year when the ferry was built
	 */
	public int getBuildYear()
	{
		return buildYear;	
	}
		
	/**
	 * Accessor for the ship name 
	 * @return Return the name of the ship
	 */
	public String getShipName()
	{
		return shipName;
	}
		
	/**
	 * Display information of the attributes about the Ferry object
	 */
	public String toString()
	{
		return ("The "+getShipName() +" ferry was built in "+getBuildYear()+", the price of the ticket is "+ getTicketPrice() + "$ and there are "+ getNumStops()+" stations");
	}
		
	/**
	 * Determine if the two objects are the same 
	 * @param f1 The other Ferry object that is compared
	 * @return Return true if the two objects are the same and false otherwise  
	 */
	
	/*
	 * Java allows to put a null object as a parameter of the equals method,
	 *  so adding the null condition will allow to check if the argument is a null object
	 *  and will return false
	 */
	public boolean equals(Ferry2 f1)
	{
		if (f1==null)
	    {
			return false;
				
		}
		else if(getClass()!= f1.getClass())
		{
			return false;
		}
		else 
		{
			return (getNumStops()==f1.getNumStops() && getTicketPrice()==f1.getTicketPrice() && getBuildYear()==f1.getBuildYear() && getShipName().equals(f1.getShipName()));
		}
	}
}
