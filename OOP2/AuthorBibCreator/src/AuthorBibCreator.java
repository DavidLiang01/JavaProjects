//-----------------------------------------------------------------------------------
//Assignment 3
//Part: Demo
//Written by: David Liang (40092433)
//-----------------------------------------------------------------------------------
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author David Liang (40092433)<br>
 * COMP 249<br>
 * Assignment #3 Part: Demo<br>
 * Due date: March 17th, 2019
 */

public class AuthorBibCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * The purpose of this program is to ask the user for the family of an author,
		 * then the program go through each .bib file to find all the articles belonging
		 * to the given family name. At the end, the program will write these articles
		 * in IEEE, ACM, and NJ format in three newly created files.
		 */
		Scanner keyboard= new Scanner(System.in);
		String author="";
		File f=null;
		File f1=null;
		File f2=null;
		File f3=null;
		PrintWriter write=null;
		PrintWriter write2=null;
		PrintWriter write3=null;
		boolean delete=false;
		Scanner read=null;
			
		System.out.println("Welcome to BibCreator! Created by David Liang\n");
		
		System.out.print("Please enter the author name you are targeting:");
		author= keyboard.nextLine();
		
		//Get path of the folder that I am working on
		String path = System.getProperty("user.dir");
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		File[] listOfFilesBib=null;
		int count =0;

		
		for (int i = 0; i < listOfFiles.length; i++)
		{
		  //Only process .bib files
		  if (listOfFiles[i].getName().endsWith(".bib")) 
		  {  
			  //Determine the number of .bib files
			  count++;
			  
			 
			  //Determine if we can read the file
			  f= new File(listOfFiles[i].getName());
			  try 
			  {
				  read=new Scanner(new FileInputStream(f.getName()));
			  } 
			  catch (FileNotFoundException e) 
			  {
				  if(read!=null)
				  {
					  read.close();
				  }
				  System.out.println("Could not open input file "+f.getName()+" for reading.");
				  System.out.println("\nPlease check if file exists! Program will terminate after closing any opened files.");		
				  System.exit(0);
			  } 
		  }
		}
		
		
		//Store only .bib files 
		listOfFilesBib=new File[count];
		count=0;
		for (int i = 0; i < listOfFiles.length; i++)
		{
			  if (listOfFiles[i].getName().endsWith(".bib"))
			  {
				  listOfFilesBib[count]=listOfFiles[i];
				  count++;
			  }
		}

		
			
		//IEEE check if file with author name already exist
		try
		{
			f1=new File(author+"-IEEE.json");
			if(f1.exists())
			{
				System.out.println("\nA file already exists with the name: "+author+"-IEEE.json");
				throw new FileExistsException("File will be renamed as "+author+"-IEEE-BU.json and any old BUs will be deleted");
			}
			
		}
		catch(FileExistsException e)
		{
			System.out.println(e.getMessage());
			//Delete BU file
			f1=new File(author+"-IEEE-BU.json");
			if(f1.exists())
			{
				f1.delete();
			}
			
			//Rename file
			f1=new File(author+"-IEEE.json");
			f1.renameTo(f1=new File(author+"-IEEE-BU.json"));	
		}
		
		//Create IEEE file
		try 
		{
			write = new PrintWriter(new FileOutputStream(author+"-IEEE.json"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File "+author+"-IEEE.json cannot be created");
			f1=new File(author+"-IEEE.json");
			f1.delete();
			delete=true;
		}
			
		
		//ACM check if file with author name already exist
		try
		{
			f2=new File(author+"-ACM.json");
			if(f2.exists())
			{
				System.out.println("\nA file already exists with the name: "+author+"-ACM.json");
				throw new FileExistsException("File will be renamed as "+author+"-ACM-BU.json and any old BUs will be deleted");
			}
			
		}
		catch(FileExistsException e)
		{
			System.out.println(e.getMessage());
			//Delete BU file if there is one
			f2=new File(author+"-ACM-BU.json");
			if(f2.exists())
			{
				f2.delete();
			}
			//Rename file
			f2=new File(author+"-ACM.json");
			f2.renameTo(f2=new File(author+"-ACM-BU.json"));

		}
		
		//Create ACM file 
		try 
		{
			if(delete==true)
			{
				throw new FileNotFoundException();

			}
			write2 = new PrintWriter(new FileOutputStream(author+"-ACM.json"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File "+author+"-ACM.json cannot be created");

		}
					
		
		//NJ check if file with author name already exist
		try
		{
			f3=new File(author+"-NJ.json");
			if(f3.exists())
			{
				System.out.println("\nA file already exists with the name: "+author+"-NJ.json");
				throw new FileExistsException("File will be renamed as "+author+"-NJ-BU.json and any old BUs will be deleted");
			}
			
		}
		catch(FileExistsException e)
		{
			System.out.println(e.getMessage());
			//Delete BU file
			f3=new File(author+"-NJ-BU.json");
			if(f3.exists())
			{
				f3.delete();
			}
			//Rename file
			f3=new File(author+"-NJ.json");
			f3.renameTo(f3=new File(author+"-NJ-BU.json"));
		}
		
		
		//Create NJ file
		try 
		{
			if(delete==true)
			{
				throw new FileNotFoundException();
			}
			write3 = new PrintWriter(new FileOutputStream(author+"-NJ.json"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File "+author+"-NJ.json cannot be created");
		}

		
		if(delete==true && write!=null)
		{
			write.close();
			System.exit(0);
		}

		
		System.out.println(processBibFiles(read, listOfFilesBib, f1,f2,f3,write,write2,write3,author));	
		System.out.println("\nGoodbye! Hope you have enjoyed creating the needed files using AuthorBibCreator.");
	}
		
	/**
	 * @param read Scanner to read the .bib files 
	 * @param bibFiles File array containing all the .bib files
	 * @param f1 File class for IEEE format
	 * @param f2 File class for ACM format
	 * @param f3 File class for NJ format
	 * @param write PrintWriter class to write on a IEEE file 
	 * @param write2 PrintWriter class to write on a ACM file
	 * @param write3 PrintWriter class to write on a NJ file
	 * @param author Author's family name that is being searched
	 * @return Return a String indicating if files have been created or not, 
	 * if so, it return the number of articles found corresponding to the author
	 */
	public static String processBibFiles(Scanner read,File[] bibFiles,File f1, File f2,File f3, PrintWriter write,PrintWriter write2, PrintWriter write3, String author)
	{
		StringTokenizer st0;
		StringTokenizer st3;
		String[] authors = null;;
		String[] authDisp=null;
		String journal="";
		String title="";
		String year="";
		String volume="";
		String number="";
		String pages="";
		String doi="";
		String month="";
		String infoIEEE="No info";
		String infoACM="No info";
		String infoNJ="No info";
		String text;
		String letter;
		int numAuth=0;
		boolean firstTime=true;
		boolean display=false;
		boolean displayMsg=false;
		
		
		
		
		for(int i=0;i<bibFiles.length;i++)
		{
			try 
			{
				read=new Scanner(new FileInputStream(bibFiles[i].getName()));
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println(bibFiles[i].getName()+" cannot be read.");
			}
			text="";
			firstTime=true;

			//Put entire file into string
			while(read.hasNextLine())
			{			
				text=text+read.nextLine()+"\n";   //read.nextLine() had been added ----> 
			}

			
			//Divide string with @ARTICLE
			st3= new StringTokenizer(text,"={,},");
			String strVali="";

			String auth="";

			while(st3.hasMoreTokens())
			{
				display=false;
				do
				{
					strVali=st3.nextToken();
					strVali=strVali.trim();
					
					switch (strVali)
					{

					case "author":
						auth=st3.nextToken();
						authors=auth.split("\\sand\\s");
						authDisp=auth.split("\\sand\\s");
						firstTime=false;
						break;
					case "journal":
						journal=st3.nextToken();
						break;
					case "title":
						title=st3.nextToken();
						break;
					case "year":
						year=st3.nextToken();
						break;
					case "volume":
						volume=st3.nextToken();
						break;
					case "number":
						number=st3.nextToken();
						break;
					case "pages":
						pages=st3.nextToken();
						break;
					case "doi":
						doi=st3.nextToken();		
						break;
					case "month":
						month=st3.nextToken();
						break;
					default:
						break;
						
					}				
				}while(!strVali.equals("@ARTICLE") && st3.hasMoreTokens());

				if(firstTime==false)
				{
					for(int scan=0;scan<authors.length;scan++)
					{			
						//Determine if the first name of author is a single letter or a word
						if(authors[scan].indexOf(".")==-1)
						{
							authors[scan]=authors[scan].substring(authors[scan].lastIndexOf(" ")+1);
						}
						else
						{
							//Determine if string ends with . like Henry Jr.
							if(authors[scan].endsWith(".")==false)
							{
								authors[scan]=authors[scan].substring(authors[scan].lastIndexOf(".")+2);
							}
							else
							{
								//Remove all . except the last one if there is one 
								while(authors[scan].indexOf(".")!=-1 && authors[scan].indexOf(".")!=authors[scan].length()-1)
								{
									authors[scan]=authors[scan].substring(authors[scan].indexOf(".")+2);
								}							
							}
						}
						if(authors[scan].equals(author))
						{
							display=true;
							displayMsg=true;
							numAuth++;
							break;
						}
					}
				}
				if(display==true)
				{
					//Write in IEEE format
					infoIEEE=auth.replaceAll("\\s\\band\\b", ",")+". \""+title+"\","+journal+", vol. "+volume+", no. "+number+", p. "+pages+", "+month+" "+year+".";
					write.println(infoIEEE+"\n");
					
					//Write in ACM format
					if(authors.length>1)
					{
						infoACM= authDisp[0]+" et al. "+year+". "+title+". "+journal+". "+volume+", "+number+" ("+year+"), "+pages+". DOI: https://doi.org/"+doi+".";
					}
					else
					{
						infoACM= authDisp[0]+". "+year+". "+title+". "+journal+". "+volume+", "+number+" ("+year+"), "+pages+". DOI: https://doi.org/"+doi+".";
					}
					write2.println("["+numAuth+"] \t"+infoACM+"\n");
					
					//Write in NJ format
					infoNJ=auth.replaceAll("\\band\\b", "&")+". "+title+". "+journal+". "+volume+", "+pages+"("+year+").";
					write3.println(infoNJ+"\n");
				}
			}
		}
		//Need to close the PrintWriter in order to delete files
		//close scanner
		if(read!=null)
		{
			read.close();
		}
		//Close PrintWriter
		if(write!=null)
		{
			write.close();
		}
		if(write2!=null)
		{
			write2.close();
		}
		if(write3!=null)
		{
			write3.close();
		}
		
		if(displayMsg==true)
		{
			return ("\nA total of "+ numAuth+" records were found for author(s) with name: "+author+"\nFiles "+author+"-IEEE.json, "+author+"-ACM.json,and "+author+"-NJ.json have been created!");
		}
		else
		{
			
			//Delete created files
			f1.delete();
			f2.delete();
			f3.delete();

			return ("\nNo records were found for author(s) with name: "+author+"\nNo files have been created!");			
		}	
		
		
		
	}

}

