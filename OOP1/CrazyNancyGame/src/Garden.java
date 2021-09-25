//--------------------------------------------------------------------
//Assignment 4 Crazy Nancy Game 
//Written by: David Liang (40092433)
//For COMP248 Section P -Fall 2018
//Submission date: November 30, 2018
//--------------------------------------------------------------------

/*The purpose of this class is to create a garden class allows the user 
 * to set the size of the garden. Also, this class contains many methods such
 * as planting tree/flower, determine spaces to plant trees/plants, etc to
 * let user to perform tasks
 */
public class Garden {
	
	//Declaring the garden array
	private char[][] garden; 
	
	//Default constructor
	public Garden()                   
	{
		garden= new char[3][3];
		this.initializeGarden();
	}
	
	//One argument constructor
	public Garden(int size)
	{
		garden= new char [size][size];
		this.initializeGarden();
	}
	
	//Method to initialize garden
	private void initializeGarden()
	{
		for (int j=0;j<garden.length;j++)
		{
			for (int i=0;i<garden.length;i++)
			{
				garden[j][i]= '-';
			}
		}
	}
	
	//Accessor for the location
	public char getInLocation(int row, int column)
	{
		return garden[row][column];
	}
	
	//Method that stores the character 'f', 't', '-'
	public void plantFlower(int row, int column)
	{
		garden[row][column]= 'f';
	}
	
	//Method to plant a tree at a location
	public void plantTree(int row, int column)
	{
		garden[row][column]= 't';
		garden[row+1][column]='t';
		garden[row][column+1]='t';
		garden[row+1][column+1]='t';
	}
	
	//Method to remove a flower or tree at a location
	public void removeFlower(int row, int column)
	{
		garden[row][column]='-';
	}
	
	//Method that counts the number of places a tree can be planted in the garden
	public int countPossibleTrees()   
	{
		int count=0;
		for (int j=0;j<garden.length-1;j++)
		{
			for (int i=0;i<garden.length-1;i++)
			{
				if (garden[j][i]=='-'&& garden[j][i+1]=='-' && garden[j+1][i]=='-' && garden[j+1][i+1]=='-')
				{
					count++;
				}
			}
		}	
		return  count;                 
	}
	
	//Method that counts the number of places a flower can be planted in the garden
	public int countPossibleFlowers()
	{
		int count=0;
		for (int j=0;j<garden.length;j++)
		{
			for (int i=0;i<garden.length;i++)
			{
				if (garden[j][i]=='-')
				{
					count++;
				}
			}
		}
		return count;             
	}
	
	//Method to determine if the garden is full or not
	public boolean gardenFull()       
	{
		if (this.countPossibleFlowers()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//toString to display data of garden
	public String toString()
	{
		String content="";
		for (int j=0;j<garden.length;j++)
		{
			if(j==0)
			{
			    content= ("\t" + "|" + "\t");
			    for (int i=0; i<garden.length;i++)
			    {
			        content= content + (i+"\t");
			    }
			}
			content= content+ ("\n"+j+"\t"+"|"+"\t");

			for (int i=0;i<garden.length;i++)
			{
				content = content+(garden[j][i]+"\t");
			}
		}
		return content;
	}
}
