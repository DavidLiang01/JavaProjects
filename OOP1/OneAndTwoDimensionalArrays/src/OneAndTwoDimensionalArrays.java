//--------------------------------------------------------------------
//Assignment 3 FIFA
//Written by: David Liang (40092433)
//For COMP248 Section P -Fall 2018
//Submission date: November 9, 2018
//--------------------------------------------------------------------
import java.util.Scanner;
import java.text.DecimalFormat;
public class OneAndTwoDimensionalArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*The purpose of this program is to ask the user for his/her favorite team in order to show the the road map of tournaments in FIFA  
		  for 16 teams  and the goals statistics until the user's favorite team wins or until it reaches 20 tournaments.   
		 */
		
		Scanner keyboard = new Scanner(System.in);		
		
		//Declaring the variables
		String[] team16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico", "Belgium", "Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland", "Colombia", "England"};
        String chosen;
        int tournament =0;
        int points;
        int k;  //count
        int i;  //count   
        int[] goals = new int[16]; 
        int[] goals_tie = new int [16];
        double[][] stats = new double[20][16];
        String[][] rounds = new String[5][];
        int points1;
        double total=0;
        double total1=0;
        double avg;
        double tot_avg=0;
        String winner =" ";
        boolean validation=false;    
        int j;   //count
        int count=0;  //count
        DecimalFormat number_format = new DecimalFormat("#.0");
        
        //Welcome message
        System.out.println("---------------------------------Welcome to FIFA-------------------------------\n");
         
       //Ask user input
       System.out.print("Enter your favorite team: ");
       chosen = keyboard.nextLine();
       chosen = chosen.replaceAll("\\s","");
       System.out.println();
       
       //Determine if user's chosen team is in one of the 16 teams
       for (int index=0; index<16;index++)
       {
           if (team16[index].equalsIgnoreCase(chosen))
           {
               validation = true;
           }           	
       }
       
       //Program ends when user input is invalid
       if (!validation)
       {
           System.out.println("Your team is not in the Round of 16");
           System.out.println("\n--------------------------------End of Program-----------------------------------");
           System.exit(0);
       }
        
        //Create a ragged array for the teams in each round and assign array team16 into it
        for (int count1=1, exp=3; count1<5;count1++)
        {
        	rounds[0] = team16;
        	rounds[count1] = new String [(int) Math.pow(2,exp)] ;
        	exp--;
        }        
                
        //Program ends when it reaches 20 tournaments or when the chosen team wins
        do 
        {
        	//This for loop goes through the rounds
        	for (j=0;j<4;j++)
        	{
        		//This for loop goes through the matches 
            	for (i=0; i<rounds[j].length; i++)                  
            	{            		
            		points = (int) (Math.random()*5);
            		goals[i]=points;
            		
            		//When the score of both teams is tie in a match
            		if (i%2 !=0 && goals[i] == goals[i-1])
            		{         			
            			for ( k=i; k>=(i-1);k--)
            			{
            				points1 = (int) Math.random()*2;
                    		goals_tie[k]=points1;   
                    		
                    		//Assign +1 to the winner for a tied match 
                    		if (k%2 ==0)
                    		{
                    			if (goals_tie[k]>goals_tie[k+1])
                    			{
                    				goals[k]= goals[i-1] + 1;
                    				goals[k+1] = goals[i];
                    			}
                    			else
                    			{
                    				goals[k+1]= goals[i] +1;
                    				goals[k] = goals[i-1];
                    			}
                    		}                		
            			}       			        			
            		}
            		
            		//Print road map and store total goals and average in the array
            		if(i==1) 
            		{
            			if (j==0)
                		{
                			System.out.print("ROUND OF 16");
                		}
                		if (j==1)
                		{
                			System.out.print("QUARTER-FINALS");
                		}
                		if (j==2)
                		{
                			System.out.print("SEMI-FINALS");
                		}
                		if (j==3)
                		{
                			System.out.print("FINAL");
                		}
            		}
            		
            		//Calculate and store the statistics in the "stats" array, calculate total goals/match, average goals/tournament and average goals for all tournaments
            		if(i%2 !=0) //PROBLEM
            		{
                		System.out.print("[" + rounds[j][i-1]+ " " + goals[i-1]+ ":"+ goals[i]+ " "+ rounds[j][i]+ "]" +" ");
                		//goals/match
                		switch (j)
                		{
                		case 0:
                    		stats[tournament][i/2] = goals[i] + goals[i-1];
                    		break;
                		case 1:
                    		stats[tournament][(i/2)+8] = goals[i] + goals[i-1];
                    		break;
                		case 2:
                    		stats[tournament][(i/2)+12] = goals[i] + goals[i-1];
                    		break;
                		case 3:
                    		stats[tournament][14] = goals[i] + goals[i-1];
                    		break;       		
                		}
            		}
            	
            		//goals/tournament
            		total = total + goals[i];           		
            		if (j==3 && i==1)
            		{
            			avg = total/15;
                		stats[tournament][15] = avg;
                		total=0;
            		}
		
            		//Determining which team is going to next round
            		if (i%2 !=0)       			
            		{
            			if (goals[i] > goals[i-1])
            			{
            				rounds[j+1][i/2] = rounds[j][i];
            			}
            			else
            			{
            				rounds[j+1][i/2] = rounds[j][i-1];
            			}
            			
            			//Display the winner of the tournament
            			if (j==3)
            			{
            				System.out.println();
            				System.out.println("Tournament: "+ tournament +" The WINNER is: "+ rounds[j+1][i/2]);
            				winner = rounds[j+1][i/2];
            			}        		
            		}
            	}
            	System.out.println();       		        	
        	}        	
        	tournament++;
        }
        while(tournament <20 && !(chosen.equalsIgnoreCase(winner)));
        
        //Tell user if their chosen team wins
        if (chosen.equalsIgnoreCase(winner))
        {
        	 System.out.println("It took "+ tournament + " tournament(s) of the game for "+ winner + " to win!!!");
        }
        else
        {
        	System.out.println("Sorry, "+ (chosen.substring(0,1).toUpperCase()+chosen.substring(1)) + " didn't win in 20 tournaments!");
        }
        
        //Calculating the average for all tournaments
        for (int index1=0; index1<tournament;index1++)
        {
        	total1 = total1 + stats[index1][15];
        }       
        tot_avg = (total1)/tournament;        
        System.out.println("\nGOAL STATS\n");
        
        //Display the statistics of the tournaments
        for (int index2 =0; index2<tournament;index2++)
        {
        	System.out.print("[Tournament " + index2 + "] "+ "Total goals: [");
        	
        	//Display the statistics of matches within a tournament
        	for (int index3=0; index3<15;index3++)
        	{
        		System.out.print((int) stats[index2][index3]);
        		if(index3<14)
        		{
        			System.out.print(", ");
        		}
        		
        		//Calculating the matches that have total goals over tot_avg
        		if (stats[index2][index3]>=tot_avg)
        		{
        			count++;
        		}
        	}
        	System.out.println("] [Average: "+ number_format.format(stats[index2][15])+ "]");
        }
        System.out.println("\nAverage goals for "+ tournament+ " tournament(s): " + number_format.format(tot_avg));
        System.out.println("Total matches in all tournaments over the average goal value: " + count);
        System.out.println("\n--------------------------------End of Program-----------------------------------");
	}
}
