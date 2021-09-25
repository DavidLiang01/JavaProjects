//---------------------------------------------------------------------------------------
//Assignment #2
//Part1: Metro
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------

package CB_T_M;

public class Metro extends CityBus{
	
	/**
	 * @author David Liang (40092433)<br>
	 * COMP 249<br>
	 * Assignment #1 Part1: Metro <br>
	 * Due date: February 20th, 2019
	 */
	private int numVehicules;
	private String cityName;
	
	/**
	 * Default constructor
	 */
	public Metro()
	{
		this.cityName="Montreal";
		this.numVehicules=8;
	}
	
	/**
	 * Parameterized constructor 
	 * @param p The price of the ticket
	 * @param s The number of stops 
	 * @param r The route number
	 * @param y The year when the route started to operate 
	 * @param l The name of the line 
	 * @param d The name of the driver
	 * @param v The number of vehicule
	 * @param c The name of the city
	 */
	
	public Metro( double p, int s, long r, int y, String l, String d, int v, String c) 
	{
		super(p,s,r,y,l,d);
		this.cityName=c;
		this.numVehicules=v;
	}
	

	/**
	 * Copy constructor 
	 * @param m1 The Metro object that is being copied
	 */
	public Metro(Metro m1)
	{
		super(m1);
		this.cityName= m1.cityName;
		this.numVehicules=m1.numVehicules;
	}
	
	/**
	 * Mutator for numVehicules 
	 * @param n The number of vehicule
	 */
	public void setNumVehicules(int n)
	{
		this.numVehicules=n;
	}
	
	/**
	 * Mutator for cityName
	 * @param c The name of the city
	 */
	public void setCityName(String c)
	{
		this.cityName=c;
	}
	
	/**
	 * Accessor for the numVehicule
	 * @return Return the number of vehicule
	 */
	public int getNumVehicules()
	{
		return numVehicules;
	}
	
	/**
	 * Accessor for the cityName
	 * @return Return the name of the city 
	 */
	public String getCityName()
	{
		return cityName;
	}
	
	/**
	 * Method that display information about the attributes of the Metro object in a string  
	 */
	public String toString()
	{
		return ("The metro line "+routeNum + " "+lineName+ " has "+ getNumVehicules()+ " vehicules and started to operate in "+startYear+ " in "+ getCityName()+ " by "+driverName+". The price of the ticket is "+ ticketPrice + "$ and there are "+ numStops+" stations");
	}
	
	/**
	 * Method that determine if all the attributes of the two Metro objects are the same  
	 * @param m1 The 
	 * @return
	 */
	
	/*
	 * Java allows to put a null object as a parameter of the equals method,
	 *  so adding the null condition will allow to check if the argument is a null object
	 *  and will return false
	 */
	public boolean equals(Metro m1)
	{
		if(m1==null)
		{
			return false;
		}
		else if (getClass()!= m1.getClass())
		{
			return false;
		}
		else 
		{
			return (routeNum==m1.routeNum && startYear==m1.startYear && lineName.equals(m1.lineName) && driverName.equals(m1.driverName) && numStops==m1.numStops && ticketPrice==m1.ticketPrice && getCityName().equals(m1.getCityName())&& getNumVehicules()==m1.getNumVehicules());
		}
	}

}
