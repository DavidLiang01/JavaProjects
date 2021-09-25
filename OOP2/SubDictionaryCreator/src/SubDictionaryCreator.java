//-----------------------------------------------------------------------------------
//Assignment 4
//Part: Sub-Dictionary Creator
//Written by: David Liang (40092433)
//-----------------------------------------------------------------------------------
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * @author David Liang (40092433)<br>
 * COMP 249<br>
 * Assignment #4 Part: Sub-Dictionary Creator<br>
 * Due date: April 8th, 2019
 */
public class SubDictionaryCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard =new Scanner(System.in);
		PrintWriter write=null;
		Scanner read =null;
		String text="";
		ArrayList<String> words = new ArrayList<String>();
		String str="";
		
		
		System.out.println("----------------------------Welcome to the Sub Dictionary Creator------------------------------------");
		System.out.print("\n\nPlease enter a text file that you want to read.");
		text= keyboard.next();
		
		//"PersonOfTheCentury.txt"
		try
		{
			read = new Scanner(new FileInputStream(text+".txt"));
		} 
		catch (FileNotFoundException e1)
		{
			System.out.println("Cannot read file. Program will terminate.");
			if(read!=null)
			{
				read.close();
			}
			System.out.println("------------------------------------End of Program----------------------------------------");
			System.exit(0);
		}
		try 
		{
			write = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Cannot write on the file. Program will terminate");
			if(read!=null)
			{
				read.close();
			}
			System.out.println("------------------------------------End of Program----------------------------------------");
			System.exit(0);
		}
		
		//Determine if the file is empty 
		if(read.hasNext()==true)
		{
			//Read until the end of file
			while(read.hasNext())
			{
				//Analyze char 
				str=read.next();
				boolean containDigit=false;
				
				//Determine if the element is a number or it contains digit
				if(str.matches(".*\\d.*")==true)
				{
					containDigit=true;
				}
				
				
				//Perform task if the word does not contain digits
				if(containDigit==false)
				{
					//Analyze char
					if(str.length()==1)
					{
						//Add char a and i in the array
						if(str.equalsIgnoreCase("a")==true || str.equalsIgnoreCase("i")==true)
						{
							//Determine if word already exist	
							if(words.contains(str.toUpperCase())==false)
							{
								words.add(str.toUpperCase());
							}
						}
						
					}
					//Analyze words 
					else
					{
						String[] punc= {"?", ":", ";", ",", "!", "."};
						//Remove punctuation from words		
						for(int i=0;i<punc.length;i++)
						{
							if(str.contains(punc[i])==true)
							{
								str=str.substring(0,str.length()-1);
								break;
							}
						}

						if(str.contains("’")==true)
						{
							str=str.substring(0,str.indexOf("’"));
						}
						if(str.contains("=")==true)
						{
							str=str.substring(str.indexOf("=")+1);
						}
						
						//Determine if word already exist	
						if(words.contains(str.toUpperCase())==false)
						{
							words.add(str.toUpperCase());
						}
					}
				}		
			}
			
			
			//Sort words in alphabetical order
			String s1="";
			String s2="";
			String temp="";
			int min=0;
			
			for(int j=0;j<words.size();j++)
			{	
				
				s1=words.get(j);
				min=j;
				for(int i=j;i<words.size();i++)
				{
					s2=words.get(i);
					
					if(s2.compareTo(s1)<0)
					{
						min=i;
						s1=words.get(i);			
					}
				}
				temp=words.get(min);
				words.set(min, words.get(j));
				words.set(j, temp);
			}
			
			String letter="0";
			String letter2;
			
			write.println("The document produced this sub-dictionary, which includes "+words.size() +" entries.");
			//Print elements of arraylist
			for(int i=0;i<words.size();i++)
			{
				s2=words.get(i);
				letter2=s2.substring(0,1);
				
				//Indication of each group
				if(letter.compareTo(letter2)!=0)
				{
					letter=letter2;
					write.println("\n"+letter2+"\n==");
					
				}
				write.println(words.get(i));

			}
			
		}
		else
		{
			write.println("The document produced this sub-dictionary, which includes 0 entries.");
		}
		
		
		write.close();
		read.close();

		System.out.println("------------------------------------End of Program----------------------------------------");


	}


}
