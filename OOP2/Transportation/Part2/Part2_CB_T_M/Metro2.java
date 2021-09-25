//---------------------------------------------------------------------------------------
//Assignment #2
//Part2: Metro2
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------
package Part2_CB_T_M;

public class Metro2 extends CityBus2 {
	/**
	 * @author David Liang (40092433)<br>
	 * COMP 249<br>
	 * Assignment #1 Part2: Metro2 <br>
	 * Due date: February 20th, 2019
	 */
	private int numVehicules;
	private String cityName;
	
	/**
	 * Default constructor
	 */
	public Metro2()
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
	
	public Metro2( double p, int s, long r, int y, String l, String d, int v, String c) 
	{
		super(p,s,r,y,l,d);
		this.cityName=c;
		this.numVehicules=v;
	}
	

	/**
	 * Copy constructor 
	 * @param m1 The Metro object that is being copied
	 */
	public Metro2(Metro2 m1)
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
		return ("The metro line "+getRouteNum() + " "+getLineName()+ " has "+ getNumVehicules()+ " vehicules and started to operate in "+getStartYear()+ " in "+ getCityName()+ " by "+getDriverName()+". The price of the ticket is "+ getTicketPrice() + "$ and there are "+ getNumStops()+" stations");
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
	public boolean equals(Metro2 m1)
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
			return (getRouteNum()==m1.getRouteNum() && getStartYear()==m1.getStartYear() && getLineName().equals(m1.getLineName()) && getDriverName().equals(m1.getDriverName()) && getNumStops()==m1.getNumStops() && getTicketPrice()==m1.getTicketPrice() && getCityName().equals(m1.getCityName())&& getNumVehicules()==m1.getNumVehicules());
		}
	}

}
