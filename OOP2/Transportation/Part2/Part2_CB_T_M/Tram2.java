//---------------------------------------------------------------------------------------
//Assignment #2
//Part2: Tram2 
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------
package Part2_CB_T_M;

public class Tram2 extends CityBus2{
	/**
	 * @author David Liang (40092433)<br>
	 * COMP 249<br>
	 * Assignment #1 Part2: Tram2 <br>
	 * Due date: February 20th, 2019
	 */
	private int maxSpeed;
		
	/**
	 * Default constructor
	 */
	public Tram2()
	{
		super();
		this.maxSpeed=200;
	}
	
	/**
	 * Parameterized constructor
	 * @param p The ticket price
	 * @param s The number of stops
	 * @param r The route number
	 * @param y The year when the route started to operate
	 * @param l The name of the line
	 * @param d The name of the driver
	 * @param sp The maximum speed
	 */
	public Tram2(double p, int s, long r, int y, String l, String d, int sp)
	{
		super(p,s,r,y,l,d);
		this.maxSpeed=sp;
	}
	
	/**
	 * Copy constructor
	 * @param t1 The Tram object that is being copied
	 */
	public Tram2(Tram2 t1)
	{
		super(t1);
		this.maxSpeed=t1.maxSpeed;
	}
	
	/**
	 * Mutator for the maximum speed
	 * @param m The maximum speed
	 */
	public void setMaxSpeed(int m)
	{
		this.maxSpeed=m;
	}
	
	/**
	 * Accessor for the maximum speed
	 * @return Return the maximum speed
	 */
	public int getMaxSpeed()
	{
		return maxSpeed;
	}
	
	/**
	 * Method that display the information of the attributes of the Tram object
	 */
	public String toString()
	{
		return ("The tram line "+getRouteNum() + " "+getLineName()+ " started to operate in "+getStartYear()+ " by "+getDriverName()+" and can reach a maximum speed of " + getMaxSpeed()+ "km/h. The price of the ticket is "+ getTicketPrice() + "$ and there are "+ getNumStops()+" stations");
	}
	
	/**
	 * Method that determines if two Tram objects are the same by comparing all the attributes of the object 
	 * @param t1 Another Tram object that is being compared to
	 * @return Return true if all the attributes of the two Tram objects are the same and false otherwise 
	 */
	
	/*
	 * Java allows to put a null object as a parameter of the equals method,
	 *  so adding the null condition will allow to check if the argument is a null object
	 *  and will return false
	 */
	public boolean equals(Tram2 t1)
	{
		if (t1==null)
		{
			return false;
		}
		else if (getClass()!=t1.getClass()) 
		{
			return false;
		}
		else
		{
			return (getRouteNum()==t1.getRouteNum() && getStartYear()==t1.getStartYear() && getLineName().equals(t1.getLineName()) && getDriverName().equals(t1.getDriverName()) && getNumStops()==t1.getNumStops() && getTicketPrice()==t1.getTicketPrice() && getMaxSpeed()==t1.getMaxSpeed());
		}
	}


}
