//-----------------------------------------------------------------------------------
//Assignment 4
//Part: CellListUtilization
//Written by: David Liang (40092433)
//-----------------------------------------------------------------------------------
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author David Liang (40092433)<br>
 * COMP 249<br>
 * Assignment #4 Part: CellListUtilization<br>
 * Due date: April 8th, 2019
 */
public class CellListUtilization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CellList l1=new CellList();
 		CellList l2=new CellList();
 		CellList l3=new CellList();
 		CellList l4;
 		CellList l5;



 		long s;
 		String b;
 		int y;
 		double p;
 		Scanner read=null;
 		Scanner keyboard= new Scanner(System.in);
 		
 		//Determine if the file can be read
 		try 
 		{
			read= new Scanner(new FileInputStream("Cell_Info.txt"));
		} 
 		catch (FileNotFoundException e) 
 		{
			System.out.println("Cannot read the file. Program will terminate.");
			if(read!=null)
			{
				read.close();
			}
			System.exit(0);
			
		}

 		//Store the info in a CellPhone object which is, then, stored in the linked list
 		while(read.hasNextLine())
 		{
 			
 			//Retrieve information from the file
 			s=read.nextLong();
 			b=read.next();
 			p=read.nextDouble();
 			y=read.nextInt();

// 			//Determine if the serial number is a duplicate or not
 			if(!l1.contains(s))
 			{
 	 			l1.addToStart(new CellPhone(s,b,y,p));
 	 			
 			}

 		}
 		read.close();
 		//Display the content of linked list
 		l1.showContents();
	
 		//Ask user to enter some serial number 
 		long[] arr= new long[3];
 		System.out.println("Please enter the serial number of 3 different phones");
 		for(int i=0;i<arr.length;i++)
 		{
 			System.out.println("Please enter the serial number of phone "+i);
 			s=keyboard.nextLong();
 			arr[i]=s;
 		}
 		
 		
 		for(int i=0;i<arr.length;i++)
 		{
 			l1.contains(arr[i]);
  		}
		
 		System.out.println("\n\n\n-----------------------Testing other methods------------------------------");
 		
 		//Creating CellPhone objects
 		CellPhone phone1=new CellPhone(1111111,"Google", 2019, 999.99);
 		CellPhone phone2=new CellPhone(2222222,"LG", 1999, 89.99);
 		CellPhone phone3=new CellPhone(phone1,1234567);
 		CellPhone phone4=new CellPhone(phone2,9999999);
 		CellPhone phone5;
 		CellPhone phone6=new CellPhone(2020202,"HTC", 2010, 299.99);
 		CellPhone phone7=new CellPhone(1111111,"Google", 2019, 999.99);
 		CellPhone phone8=new CellPhone(8888888,"Motorola", 2015, 134.89);



 		
 		
 		//Test the copy constructor for CellPhone object
 		System.out.println("\n\n\n---------------------------Testing CellPhone copy constructor----------------------------");
 		System.out.println("\nPhone1 initially:");
 		System.out.println(phone1.toString());
 		System.out.println("\nPhone3 initially:");
 		System.out.println(phone3.toString());
 		
 		//Modification of phone1
 		phone1.setBrand("Apple");
 		phone1.setPrice(1599.99);
 		System.out.println("\nPhone1 after modification:");
 		System.out.println(phone1.toString());
 		System.out.println("\nPhone3 after modification:");
 		System.out.println(phone3.toString());
 		
 		//Determine if phones are the same
 		System.out.println("\n\nEqual method");
 		System.out.println("Phone1 and phone2 are the same: "+phone1.equals(phone2));
 		System.out.println("Phone2 and phone4 are the same: "+phone2.equals(phone4));
 		
 		//Clone method
 		System.out.println("\n\n\n---------------------------Testing clone method of CellPhone----------------------------");
 		System.out.println("\nPhone2 initially:");
 		System.out.println(phone2.toString());
 		phone5 =phone2.clone(1010101);
 		System.out.println("\nPhone5 initially:");
 		System.out.println(phone5.toString());
 		
 		//Modification of phone2
 		phone2.setBrand("Nokia");
 		phone5.setPrice(1599.99);
 		System.out.println("\nPhone2 after modification:");
 		System.out.println(phone2.toString());
 		System.out.println("\nPhone5 after modification:");
 		System.out.println(phone5.toString());
 		
 		//Testing setters and getters for CellPhone object
 		System.out.println("\n\n\n-------------------------Testing setters and getters forCellPhone-----------------------------");
 		System.out.println("\nThe price of phone1 is "+phone1.getPrice());
 		phone1.setPrice(399.99);
 		System.out.println("The new price of phone1 is "+phone1.getPrice());
 		System.out.println("The brand of phone1 is "+phone1.getBrand());
 		phone1.setBrand("Siemens");
 		System.out.println("The new brand of phone1 is "+phone1.getBrand());
 		System.out.println("The serial number of phone1 is "+phone1.getSerialNum());
 		phone1.setSerialNum(3333333);
 		System.out.println("The new serial number of phone1 is "+phone1.getSerialNum());
 		System.out.println("The year of phone1 is "+phone1.getYear());
 		phone1.setYear(2020);
 		System.out.println("The new year of phone1 is "+phone1.getYear());
 		
 		
 		//Testing CellList methods 
 		System.out.println("\n\n\n----------------------Testing CellList methods--------------------------");
 		
 		//AddToStart and showContents method
 		System.out.println("\n-----------------Testing addToStart and showContents method----------------------------");
 		System.out.println("Initial CellList:");
 		l2.showContents();
 		l2.addToStart(phone3);
 		System.out.println("\nCellList after modifications:");
 		l2.showContents();
 		l2.addToStart(phone4);
 		System.out.println("\nCellList after modifications:");
 		l2.showContents();
 		l2.addToStart(phone1);
 		System.out.println("\nCellList after modifications:");
 		l2.showContents();
 		
 		//DeleteFromStart method
 		System.out.println("\n\n\n--------------------------Testing deleteFromStart method--------------------");
 		System.out.println("Initial CellList:");
 		l2.showContents();
 		l2.deleteFromStart();
 		System.out.println("\nCellList after modifications:");
 		l2.showContents();
 		l2.deleteFromStart();
 		System.out.println("\nCellList after modifications:");
 		l2.showContents();
 		l2.deleteFromStart();
 		System.out.println("\nCellList after modifications:");
 		l2.showContents();

 		//Testing find method
 		System.out.println("\n\n\n--------------------Testing find method------------------------------");
 		System.out.println("The reference for 1119000 is "+l1.find(1119000));
 		System.out.println("The reference for 1111111 is "+l1.find(1111111));
 		
 		
 		//Testing deleteFromIndex method
 		System.out.println("\n\n\n----------------------Testing deleteFromIndex method-----------------------");
 		System.out.println("Initial CellList:");
 		l2.addToStart(phone1);
 		l2.addToStart(phone2);
 		l2.addToStart(phone3);
 		l2.addToStart(phone4);
 		l2.addToStart(phone5);
 		l2.showContents();
 		
 		//Delete at the beginning of list
 		System.out.println("\nCellList after modifications:");
 		l2.deleteFromIndex(0);
 		l2.showContents();
 		
 		//Program will terminate if index is negative or greater or equal to size of the list
// 		System.out.println("\nCellList after modifications:");
// 		l2.deleteFromIndex(5);
// 		l2.showContents();
// 		System.out.println("\nCellList after modifications:");
// 		l2.deleteFromIndex(-34);
// 		l2.showContents();
 		
 		//Delete at the end
 		System.out.println("\nCellList after modifications:");
 		l2.deleteFromIndex(3);
 		l2.showContents();
 		
 		//Delete at an index
 		System.out.println("\nCellList after modifications:");
 		l2.deleteFromIndex(1);
 		l2.showContents();
 		
 		
 		
 		
 		//Testing insertAtIndex method
 		System.out.println("\n\n\n------------------------Testing insertAtIndex method-------------------------");
 		System.out.println("Initial CellList:");
 		l3.showContents();
 		System.out.println("\nCellList after modifications:");
 		
 		//Insert in empty linked list
 		l3.insertAtIndex(phone6, 0);
 		l3.showContents();
// 		System.out.println("\nCellList after modifications:");
// 		l3.deleteFromStart();
 		
 		//Throw error for index exceeding size of list
// 		l3.insertAtIndex(phone6, 3);
// 		l3.showContents();
 		
 		System.out.println("\nInitial CellList:");
 		l2.showContents();
 		
 		System.out.println("\nCellList after modifications:");
 		//Insert in linked list at a the beginning 
 		l2.insertAtIndex(phone6, 0);
 		l2.showContents();
 		System.out.println("\nCellList after modifications:");
 		
 		//Insert in linked list at an index 
 		l2.insertAtIndex(phone1, 3);
 		l2.showContents();
 		System.out.println("\nCellList after modifications:");
 		
 		//Insert in linked list at a the end  
 		l2.insertAtIndex(phone7, 4);
 		l2.showContents();
 		
 		
 		
 		//Testing replaceAtIndex method
 		System.out.println("\n\n\n-------------------Testing deleteFromIndex method----------------------");
 		
 		//Replace object an an index
 		System.out.println("\nInitial CellList:");
 		l2.showContents();
 		System.out.println("\nCellList after modifications:");
 		l2.replaceAtIndex(phone5, 3);
 		l2.showContents();
 		
 		//Replace object at invalid index
 		System.out.println("\nCellList after modifications:");
 		l2.replaceAtIndex(phone5, 8);
 		l2.showContents();
 		
 		
 		
 		
 		//Testing equals method
 		System.out.println("\n\n\n-----------------Testing equals method------------------------");
 		System.out.println("\nThe CellLists l2 and l2 are equal: "+l2.equals(l2));
 		System.out.println("The CellLists l2 and null are equal: "+l2.equals(null));
 		System.out.println("The CellLists l2 and l1 are equal: "+l2.equals(l1));
 		l5=new CellList(l2);
 		System.out.println("The CellLists l2 and l5(copy constructor of l2) are equal: "+l2.equals(l5));
 		l2.addToStart(phone8);
 		System.out.println("The CellLists l2(added a new object) and l5 are equal: "+l2.equals(l5));

 	
 		
 		//Testing CellList copy constructor
 		System.out.println("\n\n\n----------------------Testing CellList copy constructor-------------------");
 		System.out.println("Initial copy constructor:");
 		l3.addToStart(phone8);
 		l3.addToStart(phone3);
 		l3.addToStart(phone1);
 		l3.showContents();

 		System.out.println("\nModified copy constructor:");
 		l4=new CellList(l3);
 		l4.addToStart(phone2);
 		l4.addToStart(phone5);
 		l4.insertAtIndex(phone4, 3);
 		l4.showContents();
 		System.out.println("\nInitial copy constructor:");
 		l3.showContents();
 		
 		
		System.out.println("------------------------------------End of Program----------------------------------------");

 		




 		



 		
 		
 		
 		

	}

}
