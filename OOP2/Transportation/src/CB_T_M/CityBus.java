//---------------------------------------------------------------------------------------
//Assignment #2
//Part1: City Bus
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------

package CB_T_M;

import PublicTransportation.PublicTransportation; 

public class CityBus extends PublicTransportation{
	
	/**
	 * @author David Liang (40092433)<br>
	 * COMP 249<br>
	 * Assignment #1 Part1: CityBus <br>
	 * Due date: February 20th, 2019
	 */
	protected long routeNum;
	protected int startYear;
	protected String lineName;
	protected String driverName;
	
	/**
	 * Default constructor
	 */
	public CityBus()
	{
		super();
		this.routeNum=1;
		this.startYear=2019;
		this.lineName="Line Name";
		this.driverName="Driver Name";
	}
	
	/**
	 * Parameterized constructor
	 * @param p The ticket price
	 * @param s The number of stations 
	 * @param r The route number
	 * @param y The year when the line was operational 
	 * @param l The name of the line 
	 * @param d The name of the driver
	 */
	public CityBus(double p, int s, long r, int y, String l, String d)
	{
		super(p,s);
		this.routeNum= r;
		this.startYear=y;
		this.lineName=l;
		this.driverName=d;
	}
	
	/**
	 * Copy constructor 
	 * @param c1 The CityBus object that is being copied
	 */
	public CityBus(CityBus c1)
	{
		super(c1);   
		this.routeNum= c1.routeNum;
		this.startYear=c1.startYear;
		this.lineName=c1.lineName;
		this.driverName=c1.driverName;		
	}
	
	
	/**
	 * Mutator for routeNum
	 * @param r The route number
	 */
	public void setRouteNum(long r)
	{
		this.routeNum=r;
	}
	
	/**
	 * Mutator for startYear
	 * @param y The year when the route began to operate
	 */
	public void setStartYear(int y)
	{
		this.startYear=y;
	}
	
	/**
	 * Mutator for the lineName
	 * @param l The name of the line
	 */
	public void setLineName(String l)
	{
		this.lineName=l;
	}
	
	/**
	 * Mutator for the driverName
	 * @param d The name of the driver
	 */
	public void setDriverName(String d)
	{
		this.driverName=d;
	}
				

	/**
	 * Accessor for the routeNum
	 * @return Return the route number
	 */
	public long getRouteNum()
	{
		return routeNum;
	}
	
	/**
	 * Accessor for the startYear
	 * @return Return the year when the route started to operate
	 */
	public int getStartYear()
	{
		return startYear;
	}
	
	/**
	 * Accessor for the lineName
	 * @return Return the name of the line
	 */
	public String getLineName()
	{
		return lineName;
	}
	
	/**
	 * Accessor for the driverName
	 * @return Return the name of the driver
	 */
	public String getDriverName()
	{
		return driverName;
	}
	
	/**
	 * Method that display information of the attributes about the CityBus object in a string 
	 */
	public String toString()
	{
		return ("The line "+routeNum + " " +lineName+ " started to operate in "+startYear+ " by "+driverName+". The price of the ticket is "+ ticketPrice + "$ and there are "+ numStops+" stations");
	}
	
	/**
	 * Method that determine if two CityBus objects are equal 
	 * @param c1 The other CityBus object that is compared to  
	 * @return Return true if all the attributes are equal and false otherwise
	 */
	
	/*
	 * Java allows to put a null object as a parameter of the equals method,
	 *  so adding the null condition will allow to check if the argument is a null object
	 *  and will return false
	 */
	public boolean equals(CityBus c1)
	{
		if (c1==null)
		{
			return false;
		}
		else if (getClass()!=c1.getClass())
		{
			return false;
		}
		else
		{
			return (routeNum==c1.routeNum && startYear==c1.startYear && lineName.equals(c1.lineName) && driverName.equals(c1.driverName) && numStops==c1.numStops && ticketPrice==c1.ticketPrice);
		}
	}


}
