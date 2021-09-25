//-----------------------------------------------------------------------------------
//Assignment 4
//Part: CellPhone
//Written by: David Liang (40092433)
//-----------------------------------------------------------------------------------
/**
 * @author David Liang (40092433)<br>
 * COMP 249<br>
 * Assignment #4 Part: CellPhone<br>
 * Due date: April 8th, 2019
 */
public class CellPhone {
	
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * Parameterized constructor of CellPhone
	 * @param s The serial number of the phone
	 * @param b The brand of the phone 
	 * @param y The year of the phone that had been made
	 * @param p The price of the phone 
	 */
	public CellPhone(long s, String b, int y, double p)
	{
		this.serialNum=s;
		this.brand= new String(b);
		this.year=y;
		this.price=p;
	}
	
	/**
	 * Copy constructor of CellPhone 
	 * @param c The CellPhone Object that is being copied
	 * @param v The serial number of the copied constructor
	 */
	public CellPhone(CellPhone c, long v)
	{
		this.brand=c.brand;
		this.price=c.price;
		this.year=c.year;
		this.serialNum=v;
	}
	
	
	/**
	 * Mutator for serial number 
	 * @param s The new serial number that is being changed to 
	 */
	public void setSerialNum(long s)
	{
		this.serialNum=s;
	}
	
	/**
	 * Mutator for the brand
	 * @param s The new brand that is being changed to
	 */
	public void setBrand(String s)
	{
		this.brand=s;
	}
	
	/**
	 * Mutator for the year
	 * @param y The new year that is being changed to
	 */
	public void setYear(int y)
	{
		this.year=y;
		
	}
	
	/**
	 * Mutator for the price
	 * @param p The new price that is being changed to
	 */
	public void setPrice(double p)
	{
		this.price=p;
	}
	
	/**
	 * Accessor for the serial number 
	 * @return Return the serial number of the phone 
	 */
	public long getSerialNum()
	{
		return this.serialNum;
	}
	
	/**
	 * Accessor for the brand
	 * @return Return the brand of the phone
	 */
	public String getBrand()
	{
		return this.brand;
	}

	
	/**
	 * Accessor for the year 
	 * @return Return the year of the phone 
	 */
	public int getYear()
	{
		return this.year;
	}
	
	/**
	 * Accessor for the price
	 * @return Return the price of the phone 
	 */
	public double getPrice()
	{
		return this.price;
	}
	
	/**
	 * Display the information of the CellPhone object such as the brand, year, serial number and price
	 */
	public String toString()
	{
		return "This phone is a "+this.getBrand()+" made in "+this.getYear()+" that costs "+this.getPrice()+" and its serial number is "+this.getSerialNum();
	}
	
	/**
	 * Clone method to create a duplicate for the calling CellPhone object
	 * @param v The serial number of the cloned CellPhone object
	 * @return Return the cloned CellPhone object
	 */
	public CellPhone clone(long v)
	{
		
		return new CellPhone(this,v);
	}
	
	/**
	 * Determine if the two CellPhone objects are equal by comparing the price, the brand and the year
	 * @param c The CellPhone object that is being compared to
	 * @return Return true if the year, brand and price are the same for both, otherwise false
	 */
	public boolean equals(CellPhone c)
	{
		if(c==null)
		{
			return false;
		}
		else if (getClass()!=c.getClass())
		{
			return false;
		}
		else
		{
			return this.getBrand().equals(c.getBrand()) && this.getYear()==c.getYear() && this.getPrice()==c.getPrice();
		}
		
	}
}
