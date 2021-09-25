//--------------------------------------------------------------------
//Assignment 3 House 
//Written by: David Liang (40092433)
//For COMP248 Section P -Fall 2018
//Submission date: November 9, 2018
//--------------------------------------------------------------------
public class House {
	
	//The purpose of this program is to create a class containing constructors with different arguments and methods(get, set, estimatePrice, isLessThan,
	//isGreaterThan, toString,and more), then use them in the drive to see if it gives the expected results
	
	//Declaring attributes
	private int age;
	private String type;
	private double cost;

	//Constructor with no argument
	public House()
	{
		age = 50;
		type = "attached";
		cost = 100000;
	}
	
	//Constructor with one argument
	public House (double cost1)
	{		
		cost=cost1;
		age = 50;
		type= "attached";
	}
	
	//Constructor with two arguments
	public  House (double cost2, int age2)
	{		
		cost=cost2;
		age= age2;
		type = "attached";
	}
	
	//Constructor with three arguments
	public House (double cost3, int age3, String type3)
	{		
		cost=cost3;
		age=age3;
		type=type3;
	}
	
	//Mutator methods
	//set age
	public void setAge(int age)
	{
		this.age=age;
	}
		
	// set type
	public void setType(String type)
	{
		this.type = type;		
	}
		
	//set cost
	public void setCost(double cost)
	{
		this.cost = cost;
	}
		
	//set age, type,cost
	public void setData(int age, String type, double cost)
	{
		this.age= age;
		this.type= type;
		this.cost=cost;
	}
		
	//set age and cost
	public void setAgeCost(int age, double cost)
	{
		this.age = age;
		this.cost= cost;
	}
	
	//Accessor method
	//Return the age 
	public int getAge()
	{
		return age;
	}
	
	//Return the type 
	public String getType()
	{
		return type;
	}
	
	//Return the cost
	public double getCost()
	{
		return cost;
    }
	
	//Display data of house
	public void outputData()
	{
		System.out.println("This House is type "+ this.type + ". Its age is "+ this.age + " and costs $"+ this.cost);
	}
	
	//Method to estimate price
	//There was an ERROR for the FORMULA used to calculate the ESTIMATED PRICE in the assignment, THE TEACHER said to use the RIGHT one  
	public void estimatePrice()
	{
		//estimate price for attached houses
		if (type.equals("attached"))
		{
			cost =100000;
			if (age<=5)
			{
				for (int i=age; i!=0;i--)
				{
					cost =cost*1.01;
				}
			}
					
			if (age >5)
			{
				cost =100000;
				for (int i=5; i!=0;i--)
				{
					cost =cost*1.01;
				}
				
				for (int j=age-5; j!=0;j--)
				{
					cost = cost*(1.02);
				}
			}			
		}
		
		//estimate price for semi-detached houses
		if (type.equals("semi-detached"))
		{
			cost =150000;
			if (age<=5)
			{
				for (int i=age; i!=0;i--)
				{
					cost =cost*1.02;
				}
			}
					
			if (age >5)
			{
				cost =150000;
				for (int i=5; i!=0;i--)
				{
					cost =cost*1.02;
				}
				
				for (int j=age-5; j!=0;j--)
				{
					cost = cost*(1.03);
				}
			}			
		}
				
		//estimate price for detached houses 
		if (type.equals("detached"))
		{
			cost=200000;
			for (int i=age;i!=0;i--)
			{
				cost = cost* 1.02;
			}
		}
	}
	
	public String toString() 
	{
    	return ("This House is type " + type + ". "+ "Its age is "+ age+ " and costs $"+ cost);
	}
	
	//Determine if the data for two houses are the same
	public boolean equals(House anotherHouse)
	{
		return ((age==anotherHouse.age) && (cost==anotherHouse.cost) && (type.equals(anotherHouse.type)) );
	}
	
	//Determine which price is the lowest between 2 houses
	public boolean isLessThan(House anotherHouse)
	{
		if (cost<anotherHouse.cost)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Determine which price is the greatest between 2 houses
	public boolean isGreaterThan(House anotherHouse)
	{
		if (cost>anotherHouse.cost)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

//The test code is in the other java file