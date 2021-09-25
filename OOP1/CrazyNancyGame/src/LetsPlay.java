//--------------------------------------------------------------------
//Assignment 4 Crazy Nancy Game 
//Written by: David Liang (40092433)
//For COMP248 Section P -Fall 2018
//Submission date: November 30, 2018
//--------------------------------------------------------------------

//This is the driver where players play the game. This is where the rules are shown and it is where the users can use different actions (the game starts here) 
import java.util.Scanner;
public class LetsPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
	
		//Welcome banner
		System.out.println("-------****-------****-------****-------****-------****-------");
		System.out.println("       Welcome to Crazy Nancy's Garden Game!                  ");
		System.out.println("-------****-------****-------****-------****-------****-------");
		
		//Display rules of the game
		System.out.println("To win this game you need some luck with the dice and a bit of strategy.\r\n" + 
				"Your garden is an NxN lot. You can plant flowers or trees. A flower takes one spot. A tree takes 4 spots (2x2).\r\n" + 
				"You roll the dice and based on the outcome you get to plant a pre-set number of trees and flowers.\n");
		
		System.out.println("Rolls and their outcome:");
		System.out.println("---------------------");
		
		System.out.println(" 3: plan a tree (2x2) and a flower (1x1)\r\n" + 
				" 6: plant 2 flowers (2 times 1x1)\r\n" + 
				" 12: plant 2 trees (2 times 2x2)\r\n" + 
				" 5 or 10: the rabbit will eat something that you have planted - might be a flower or part of a tree(1x1)\r\n"+
				" Any other EVEN rolls: plant a tree (2x2)\r\n" + 
				" Any other ODD rolls: plant a flower (1x1)\n");
		
		System.out.println("Minimum number of players: 2.\r\n" + 
				"Minimum garden size: 3x3.\r\n" + 
				"You can only plant in empty locations. To plant a tree you give the top left coordinates of the 2x2 space\r\n" + 
				"and I will check to make sure all 4 locations are free.\r\n" + 
				"Okay .. Let's start the game! May the best gardener win!!!\n\n");

		System.out.println("The default garden size is a 4x4 square. You can use this default board size or change the size");

		//Declaring variables
		int coord;
		int coord2;
		int user_choice;
		int num_players;
	    int size=3;
		Player[] players;
		int [][] value;
		String name;
		Dice dice= new Dice();
		int max=0;
		boolean valid=false;
		int first;
		int scan=0;
		int count;
		
		//Validate the input of the user 
		do 
		{
			//Ask user for inputs
			System.out.print("Enter 0 to use the default garden size or -1 to enter your own size: ");
			user_choice= keyboard.nextInt();
			
			//Determine we use default garden or not
			if (user_choice==0)
			{
                size=3;
			}
			if (user_choice==-1)
			{
				//Ask the size of the board if user didn't choose the default board
				System.out.println("What size board would you like? (minimum size 3) ");
				
				//Validate the user input of board size
				do
				{
					size=keyboard.nextInt();
					if (size<3) 
					{
						System.out.println("Error! The size of the board must be a least 3.");
						System.out.println("Re-enter the size of the board.");
					}
				}while (size<3);				
			}
			
			//Display message if user input is invalid
			if (user_choice!=0 && user_choice!=-1)
			{
				System.out.println("\nSorry but "+ user_choice+ " is not a legal choice. Enter your choice:");				
			}
		}while(user_choice!=0 && user_choice!=-1);
		
		//Ask user to input the number of players and validate user input		
		do
		{
			System.out.print("How many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
			num_players= keyboard.nextInt();
			if(num_players<2 || num_players>10)
			{
				System.out.println("\nSorry but "+num_players+ " is not a legal number of players.");
			}
		}while(num_players<2 || num_players>10);
		value = new int [2][num_players];
		players= new Player[num_players];
		
		System.out.println("\nGreat, "+num_players+ " players it will be!");
		
		//Ask user for player names
		for(int i=0;i<num_players;i++)
		{
			System.out.print("--> Name of player "+(i+1)+ " (no space allowed): ");
			name= keyboard.next();
			players[i]= new Player(name, size);
			System.out.println();
		}
		
		System.out.println("Let's see who goes first...");
		
		//Validate if two players have the same value
		do
		{
			//Assign random dice value to players
			for (int i=0;i<num_players;i++)
			{
				value[1][i]= dice.rollDice();
				System.out.println(players[i].getName()+ " rolled a "+ (dice.getValue1()+dice.getValue2()));	
			}
			
			//Validate if two players have same value
			valid=false;
			for (count=0;count<num_players && valid!=true;count++)
			{
				for (scan=count+1;scan<num_players;scan++)
				{
					if (value[1][count]==value[1][scan])
					{
						valid=true;
						break;
					}
				}
			}	
			
			if(valid==true)
			{
				System.out.println("We will start over as "+ value[1][count-1]+ " was rolled by "+ players[scan].getName()+ " as well.\n");
			}
		}while(valid==true);
		
		//Determine the player who has the highest value 
		for (int i=0;i<num_players;i++)
		{
			max= Math.max(max, value[1][i]);
		}
		
		valid=false;
		for (first=0;first<num_players && valid!=true ;first++)
		{
			if (max==value[1][first])
			{
				valid=true;
				break;
			}
		}
		System.out.println("\n"+players[first].getName()+ " goes first.");
		System.out.println("\nTime to play!!!!");
		System.out.println("------------------------------\n");
	
		//The game starts and it continues until one of the players' garden is full
		scan=0;
		int i =first;
		do
		{
			//Count the number of rounds
			if (players[i]==players[first])
			{
				scan++;
			}
			
			//Make sure that it does roll a 5 or 10 in the first round since the garden is empty
			do
			{
				value[1][i]= dice.rollDice();

			}while((value[1][i]==5 || value[1][i]==10) && scan==1);
			System.out.println("\n\n"+players[i].getName()+", you rolled "+ value[1][i]+ " ("+ dice.toString()+ ")" );
			
			//Determine what is planted based on the value
			switch (value[1][i])
			{
			//Plant a tree and a flower
			case 3:	
				System.out.println("You must plant a tree (2x2) and a flower (1x1)\n");
				break;
			
			//Plant 2 flowers	
			case 6:
				System.out.println("You must plant 2 flowers (2 times 1x1)");
				System.out.println("You have "+ players[i].howManyFlowersPossible()+ " places to do this.\n");
				break;
			
			//Plant 2 trees	
			case 12:
				System.out.println("You must plant 2 trees (2 times 2x2)\n");
				break;
				
			//Plant a tree	
			case 2: case 4: case 8:
				System.out.println("You must plant a tree (2x2)\n");
				break;
				
			//Plant a flower	
			case 7: case 9: case 11:
				System.out.println("You must plant a flower (1x1)\n");
				break;
			}	
			
			System.out.println(players[i].showGarden());
			
			switch (value[1][i])
			{
			//Rabbit eat tree or flower	
			case 5: case 10:
				
				//Validate if the location has a tree or flower so that it can be removed
				do
				{
					coord= (int) (Math.random()*(size-1));
					coord2= (int) (Math.random()*(size-1));
				}while(players[i].whatIsPlanted(coord, coord2)=='-');
				players[i].eatHere(coord, coord2);
				System.out.println("\nThe rabbit ate whatever was planted in location (" + coord + "," + coord2+")\n");
				System.out.println(players[i].showGarden());
				break;
			
			//Plant tree 
			case 2: case 3: case 4: case 8: case 12:
				
				//Determine if there is space left to plant a tree
				if (players[i].howManyTrees()==0)
				{
					System.out.println("\nSorry, no room to plant a tree! You miss a turn.");
				}
				else
				{
					//If value is 3
					if(value[1][i]==3)
					{
						System.out.println("\nLets start with the tree. You have "+ players[i].howManyTrees()+" places to do this.");
					}
					
					//If value is 12
					else if(value[1][i]== 12)
					{	
						System.out.println("\nYou have "+ players[i].howManyTrees()+ " places to do this.");
						System.out.print("First tree - ");
					}
					else
					{
						System.out.println("\nYou have "+ players[i].howManyTrees()+ " places to do this.");
					}
					
					System.out.print("Enter coordinates as row column: ");
					coord= keyboard.nextInt();
					coord2= keyboard.nextInt();
					
					//Verify if the coordinates are outside the grid or negative
					while(coord>=size || coord2>=size || (coord+1)>=size || (coord2 +1)>=size || coord<0 || coord2 <0)
					{
						System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + " or your tree will be off the grid. Try again.");
						System.out.print("Enter coordinates as row column: ");
						coord= keyboard.nextInt();
						coord2= keyboard.nextInt();
					}
					
					//Verify if the four locations are free
					while(players[i].whatIsPlanted(coord, coord2)!='-'|| players[i].whatIsPlanted(coord, 1+coord2)!='-' || players[i].whatIsPlanted(coord+1, coord2)!='-'|| players[i].whatIsPlanted(coord+1, 1+coord2)!='-')
					{
						//Check if there is a tree of flower at that location
						if(players[i].whatIsPlanted(coord, coord2)!='-')
						{
							System.out.println("\n**Sorry, that location is already taken up by a: "+ players[i].whatIsPlanted(coord, coord2));
						}
						
						//Verify if we can plant a tree 
						if(players[i].whatIsPlanted(coord, coord2)!='-' || players[i].whatIsPlanted(coord, 1+coord2)!='-' || players[i].whatIsPlanted(coord+1, coord2)!='-'||  players[i].whatIsPlanted(coord+1, 1+coord2)!='-')
						{
							System.out.println("\nSorry, you cannot plant a tree at this location!");
						}
						System.out.print("Enter coordinates as row column: ");
						coord= keyboard.nextInt();
						coord2= keyboard.nextInt();
						
						//Verify if the coordinates are outside the grid or negative
						while(coord>=size || coord2>=size || (coord+1)>=size || (coord2 +1)>=size || coord<0 || coord2 <0)
						{
							System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + " or your tree will be off the grid. Try again.");
							System.out.print("Enter coordinates as row column: ");
							coord= keyboard.nextInt();
							coord2= keyboard.nextInt();
						}
					}
			        players[i].plantTreeInGarden(coord, coord2);

			        //Plant second tree if value is 12
					if (value[1][i]==12)
					{
						System.out.println(players[i].showGarden());
						System.out.print("\nSecond tree - ");
						
						//Verify if we can plant the second tree
						if (players[i].howManyTrees()==0)
						{
							System.out.println("\nSorry, no room to plant the second tree! You miss a turn.");
						}
						else
						{
							System.out.print("Enter coordinates as row column: ");
							coord= keyboard.nextInt();
							coord2= keyboard.nextInt();
							
							//Verify if the coordinates are outside the grid or negative
							while(coord>=size || coord2>=size || (coord+1)>=size || (coord2 +1)>=size || coord<0 || coord2 <0)
							{
								System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + " or your tree will be off the grid. Try again.");
								System.out.print("Enter coordinates as row column: ");
								coord= keyboard.nextInt();
								coord2= keyboard.nextInt();
							}
							
							//Verify if the 4 spaces are free
					        while(players[i].whatIsPlanted(coord, coord2)!='-'|| players[i].whatIsPlanted(coord, 1+coord2)!='-' || players[i].whatIsPlanted(coord+1, coord2)!='-'|| players[i].whatIsPlanted(coord+1, 1+coord2)!='-')
							{
								//Check if there is a tree of flower at that location
								if(players[i].whatIsPlanted(coord, coord2)!='-')
								{
									System.out.println("\n**Sorry, that location is already taken up by a: "+ players[i].whatIsPlanted(coord, coord2));
								}
								
								//Verify if we can plant a tree 
								if(players[i].whatIsPlanted(coord, coord2)!='-' || players[i].whatIsPlanted(coord, 1+coord2)!='-' || players[i].whatIsPlanted(coord+1, coord2)!='-'||  players[i].whatIsPlanted(coord+1, 1+coord2)!='-')
								{
									System.out.println("\nSorry, you cannot plant a tree at this location!");
								}
								System.out.print("Enter coordinates as row column: ");
								coord= keyboard.nextInt();
								coord2= keyboard.nextInt();
								
								//Verify if the coordinates are outside the grid or negative
								while(coord>=size || coord2>=size || (coord+1)>=size || (coord2 +1)>=size || coord<0 || coord2 <0)
								{
									System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + " or your tree will be off the grid. Try again.");
									System.out.print("Enter coordinates as row column: ");
									coord= keyboard.nextInt();
									coord2= keyboard.nextInt();
								}
							}
						    players[i].plantTreeInGarden(coord, coord2);
						}
					}	
				  }
			    		
				if(value[1][i]!=3 || players[i].isGardenFull())
				{
					break;
				}
		
			//Plant flower	
			default:
				//If value is 3
				if (value[1][i]==3)
				{
					System.out.println("\nYou still have a flower (1x1) flower to plant.\n");	
					System.out.println(players[i].showGarden());
					System.out.println("\nYou now have "+ players[i].howManyFlowersPossible()+ " places to do this.\n");
				}	
				
				//If value is 6
				else if(value[1][i]==6)
				{
					System.out.print("\nFirst flower - ");													
				}
				else
				{
					System.out.println("\nYou now have "+ players[i].howManyFlowersPossible()+ " places to do this.\n");
				}
				
				System.out.print("Enter coordinates as row column: ");
				coord= keyboard.nextInt(); 
				coord2=keyboard.nextInt();
				
				//Verify if the coordinates are outside the grid or negative
				while(coord>=size || (coord2)>=size || coord<0 || coord2 <0)
				{
					System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + ". Try again.");
					System.out.print("Enter coordinates as row column: ");
					coord= keyboard.nextInt(); 
					coord2=keyboard.nextInt();		
				}
				
		    	//Validate if there is something in the location, if so ask user input until the input location is free
			    while(players[i].whatIsPlanted(coord, coord2)!='-')
			    {						
					System.out.println("\n**Sorry, that location is already taken up by a: "+ players[i].whatIsPlanted(coord, coord2));
					System.out.print("Enter coordinates as row column: ");
					coord= keyboard.nextInt(); 
					coord2=keyboard.nextInt();
					
					//Verify if the coordinates are outside the grid or negative
					while(coord>=size || (coord2)>=size || coord<0 || coord2 <0)
					{
						System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + ". Try again.");
						System.out.print("Enter coordinates as row column: ");
						coord= keyboard.nextInt(); 
						coord2=keyboard.nextInt();		
					}
				}				
			    players[i].plantFlowerInGarden(coord, coord2);
			
				if (value[1][i]==6  )
				{
					if (players[i].isGardenFull())
					{
						break;
					}
					players[i].showGarden();
					System.out.print("Second flower - ");
					System.out.print("Enter coordinates as row column: ");
					coord= keyboard.nextInt(); 
					coord2=keyboard.nextInt();
					
					//Verify if the coordinates are outside the grid or negative
				        while(coord>=size || coord2>=size || coord<0 || coord2 <0)
						{
							System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + " . Try again.");
							System.out.print("Enter coordinates as row column: ");
							coord= keyboard.nextInt(); 
							coord2=keyboard.nextInt();		
						}

						//Validate if there is something in the location, if so ask user input until the location is free
				        while(players[i].whatIsPlanted(coord, coord2)!='-')
						{							
		          			System.out.println("\n**Sorry, that location is already taken up by a: "+ players[i].whatIsPlanted(coord, coord2));
							System.out.print("Enter coordinates as row column: ");
							coord= keyboard.nextInt(); 
							coord2=keyboard.nextInt();
							
							//Verify if the coordinates are outside the grid or negative
							while(coord>=size || (coord2)>=size || coord<0 || coord2 <0)
							{
								System.out.println("\n**Sorry either the row or column is not in the range of 0 to "+ (size-1) + ". Try again.");
								System.out.print("Enter coordinates as row column: ");
								coord= keyboard.nextInt(); 
								coord2=keyboard.nextInt();		
							}
						}
				    players[i].plantFlowerInGarden(coord, coord2);
				  }	
				break;	
			}
	
			//Check if the garden is full
			if (players[i].isGardenFull())
			{
				System.out.println("\n\nFINAL RESULTS");
				System.out.println("-------------");
				System.out.println("Here are the gardens after "+ scan+ " rounds.");
				for (int j=0;j<num_players;j++)
				{
					System.out.println(players[j].getName()+ "\'s garden\n");
					System.out.println(players[j].showGarden());
					System.out.println("\n\n");
				}
				System.out.println("And the winner is....."+ players[i].getName()+"!!!!!");
				System.out.println("What a beautiful garden tou have.\nHope you had fun!!!! ");
                System.exit(0);				
			}
			if (i==num_players-1)
			{
				i=0;
			}
			else
			{
				i++;
			}
		}while(!(players[i].isGardenFull()));
		keyboard.close();
	}
}
