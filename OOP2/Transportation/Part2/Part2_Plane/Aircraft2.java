//---------------------------------------------------------------------------------------
//Assignment #2
//Part2: Aircraft2
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------
package Part2_Plane;

import Part2_PublicTransportation.PublicTransportation2;


public class Aircraft2 extends PublicTransportation2{
	/**
	 * @author David Liang (40092433)<br>
	 * COMP 249<br>
	 * Assignment #1 Part2: Aircraft2 <br>
	 * Due date: February 20th, 2019
	 */
	public enum classType {HELICOPTER, AIRLINE, GLIDER, BALLOON};
	public enum maintenance {WEEKLY, MONTHLY, YEAR};
	
	private classType chosenType;
	private maintenance chosenMaint;
	
	/**
	 * Default constructor
	 */
	public Aircraft2()
	{
		super();
		this.chosenType= classType.HELICOPTER;
		this.chosenMaint = maintenance.WEEKLY;
	}
	
	/**
	 * Parameterized constructor
	 * @param t The ticket price
	 * @param n The number of stop
	 * @param ty The aircraft type
	 * @param m The frequency of maintenance  
	 */
	public Aircraft2(double t, int n, classType ty, maintenance m)
	{
		super(t,n);
		this.chosenType = ty; 
		this.chosenMaint = m;
	}
	
	/**
	 * Copy constructor
	 * @param a1 The Aircraft object that is being copied
	 */
	public Aircraft2 (Aircraft2 a1)
	{
		super(a1);
		this.chosenMaint=a1.chosenMaint;
		this.chosenType=a1.chosenType;
		
	}
	
	/**
	 * Mutator for the classType
	 * @param t The classType that is chosen
	 */
	public void setChosenType(classType t)
	{
		this.chosenType=t;
	}
	
	/**
	 * Mutator for the maintenance frequency
	 * @param m The maintenance type that is chosen
	 */
	public void setChosenMaint(maintenance m)
	{
		this.chosenMaint=m;
	}
	
	/**
	 * Accessor for the classType
	 * @return Return the aircraft type as classType
	 */
	public classType getChosenType()
	{
		return this.chosenType;
	}
	
	/**
	 * Accessor 
	 * @return Return the maintenance frequency of the aircraft
	 */
	public maintenance getChosenMaint()
	{
		return this.chosenMaint;
	}
	
	/**
	 * Method that displays the information of the Aircraft object
	 *
	 */
	public String toString()
	{
		return ("The aircraft type is a "+getChosenType()+ " that is maintained " +getChosenMaint()+" and the price of the ticket is "+ getTicketPrice() + "$ and there are "+ getNumStops()+" stations");
	}
	
	/**
	 * Method that determines if all the attributes of the two Aircraft objects are the same
	 * @param a1 The other Aircraft object that is being compared to
	 * @return Return true if all the attributes of both objects are the same and return false otherwise
	 */
	
	/*
	 * Java allows to put a null object as a parameter of the equals method,
	 *  so adding the null condition will allow to check if the argument is a null object
	 *  and will return false
	 */
	public boolean equals(Aircraft2 a1)
	{
		if (a1==null)
		{
			return false;
		}
		else if(getClass()!=a1.getClass())
		{
			return false;
		}
		else
		{
			return (getNumStops()==a1.getNumStops() && getTicketPrice()==a1.getTicketPrice() && getChosenType().equals(a1.getChosenType()) && getChosenMaint().equals(a1.getChosenMaint()));
		}
	}

}
