//--------------------------------------------------------------------
//Assignment 4 Crazy Nancy Game 
//Written by: David Liang (40092433)
//For COMP248 Section P -Fall 2018
//Submission date: November 30, 2018
//--------------------------------------------------------------------

/*The purpose of this class is to allow user to access the methods in the garden
 * class since garden is private 
 */
public class Player {
	
	//Declaring attributes
	private String name;
	private Garden garden;
	
	//Declaring the constructors
	public Player(String name, int size)
	{
		this.name= name;
        garden= new Garden(size);
	}
	
	//Accessor for the name
	public String getName()
	{
		return name;
	}
	
	//Method to get the possible spaces that the gardener can plant a flower
	public int howManyFlowersPossible()
	{
		return garden.countPossibleFlowers();
	}
	
	//Method to get the possible spaces that the garderner can plant a tree 
	public int howManyTrees()
	{
		return garden.countPossibleTrees();
	}
	
	//Method to let the player know what is planted at a location
	public char whatIsPlanted(int row, int column)
	{
		return garden.getInLocation(row, column);
	}
	
	//Method that allows player to plant a tree at a location
	public void plantTreeInGarden(int row, int column)    
	{
		garden.plantTree(row, column);
	}
	
	//Method that allows the player to plant a flower at a location
	public void plantFlowerInGarden(int row, int column)  
	{
		garden.plantFlower(row, column);
	}
	
	//Method that removes a flower or a tree at a specific location
	public void eatHere(int row, int column)
	{
		garden.removeFlower(row, column);
	}
	
	//Method that verify if the garden is full
	public boolean isGardenFull()
	{
		return garden.gardenFull();
	}
	
	//Method that allows players to see their garden
	public String showGarden()   
	{
		return garden.toString();
	}
}
