//-----------------------------------------------------------------------------------
//Assignment 4
//Part: CellList
//Written by: David Liang (40092433)
//-----------------------------------------------------------------------------------
import java.util.NoSuchElementException;

/**
 * @author David Liang (40092433)<br>
 * COMP 249<br>
 * Assignment #4 Part: CellList<br>
 * Due date: April 8th, 2019
 */
public class CellList {
	
	//If the CellNode was public, privacy leak will be an issue since it can access the reference of
	//the node and change the content. 
	private class CellNode
	{
		private CellPhone cp;
		private CellNode cn;
		
		/**
		 * Default constructor for CellNode
		 */
		public CellNode()
		{
			this.cp=null;
			this.cn=null;
		}
		
		/**
		 * Parameterized constructor for CellNode
		 * @param p CellPhone object
		 * @param n The node of the CellPhone object
		 */
		public CellNode(CellPhone p, CellNode n)
		{
			this.cn=n;
			this.cp=p;
		}
		
		/**
		 * Copy constructor for CellNode
		 * @param n CellNode object that is being copied 
		 */
		public CellNode(CellNode n)
		{		
			this.cn=n.getCn();
			this.cp=n.getCp();
		}
		
		/**
		 * Clone method to create a duplicate of the calling CellNode object 
		 */
		public CellNode clone()
		{	
			return new CellNode(this);
		}
		
		/**
		 * Mutator for cn
		 * @param n The new CellNode that is being changed to
		 */
		public void setCn(CellNode n)
		{
			this.cn=n;
		}
		
		/**
		 * Mutator for cp
		 * @param p The new CellPhone that is being changed to 
		 */
		public void setCp(CellPhone p)
		{
			this.cp=p;
		}
		
		/**
		 * Accessor for CellNode object
		 * @return Return the CellNode object
		 */
		public CellNode getCn()
		{
			return this.cn;
		}
		
		/**
		 * Accessor for the CellPhone object
		 * @return Return the CellPhone object
		 */
		public CellPhone getCp()
		{
			return this.cp;
		}
				
	}
	
	
	private CellNode head;
	private int size;
	
	/**
	 * Default constructor for CellList
	 */
	public CellList()
	{
		head=null;
	}
	
	/**
	 * Copy constructor for CellList
	 * @param c Return the CellList object that is being copied
	 */
	public CellList(CellList c)
	{
		//In the case that the passed in object is null
		if(c==null)
		{
			throw new NullPointerException();
		}
		//If the list is empty
		if(c.head==null)
		{
			head=null;
		}
		else
		{
			CellNode position=c.head;  //take the head of passed in object
			CellNode newHead;
			CellNode end=null;    
			newHead =new CellNode(position.clone());  //copy the node
			end=newHead;
			position=position.getCn(); 
		
			while(position!=null)
			{
				end.cn=new CellNode(position.clone());
				end=end.getCn();
				position=position.getCn();
			}
			head=newHead;
		}
		
		
	}
	
	/**
	 * Method that adds a CellPhone object at the beginning of the list
	 * @param p The CellPhone object that is being add to the list
	 */
	public void addToStart(CellPhone p)
	{
		head= new CellNode(p,head);
		
	}
	/**
	 * Determine the number of CellPhone object in the linked list
	 * @return
	 */
	public int size()
	{
		size=0;
		CellNode position = head;
		while(position!=null)
		{
			size++;
			position=position.getCn();
		}
		return size;
	}
	

	/**
	 * Method that inserts a CellPhone object at a specific location in the linked list
	 * @param c The CellPhone object that is being inserted
	 * @param i The index position where the object is being inserted
	 */
	public void insertAtIndex(CellPhone c, int index)
	{
		int currentIndex=0;
		CellNode position=head;
		CellNode previous=null;
		CellNode nodeObject;


		//Throw NoSuchElementException
		try
		{
			if(((index<0 || index > this.size()) && this.size()!=0) || ((index<0 || index > this.size()) && this.size()==0))
			{
				throw new NoSuchElementException("The index inputted is invalid. System wil terminate.");

			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println(e);
			System.exit(0);
			
		}
		
		
		//Insert the object at the designated location
		
		//If the index=0 or the linked list is empty,then the addToStart method is used
		if(index==0 || this.size()==0)
		{
			this.addToStart(c);
		}
		else
		{
			while(position!=null)
			{
				if(currentIndex==index)
				{
					nodeObject= new CellNode(c,position);
					previous.cn=nodeObject;
					break;
				}
				previous=position;
				position=position.getCn();
				currentIndex++;	
			}
			//Insert at the end of the linked list
			if(this.size()==index)
			{
				if(position==null)
				{
					nodeObject= new CellNode(c,null);
					previous.cn=nodeObject;
				}
			}
		}
		
	}
	
	/**
	 * Delete the head node of CellPhone object 
	 * @param index The position of the object that user want to remove
	 */
	public void deleteFromIndex(int index)
	{
		//Throw NoSuchElementException
		try
		{
			if(index<0 || index >= this.size())
			{
				throw new NoSuchElementException("The index inputted is invalid. System wil terminate.");

			}
		}
		catch (NoSuchElementException e)
		{
			//Terminate program
			System.out.println(e);
			System.exit(0);
			
		}
				
		CellNode position=head;
		CellNode previous=null;
		int count=0;
		//If the index is 0, the deleteFromStart method is used
		if(index==0)
		{
			this.deleteFromStart();
		}
		else
		{
			//Go through the linked list
			while(position!=null)
			{
				if(count==index)
				{
					//delete the pointer of the object that needs to be removed
					previous.cn=position.getCn();
					position=position.getCn();
					break;
				}
				//Go to next node
				previous=position;
				position=position.getCn();
				count++;
			}
		}
		
		
	}
	
	/**
	 * Remove CellPhone object at the beginning of the linked list
	 */
	public void deleteFromStart()
	{
		if(head!=null)
		{
			head=head.getCn();
		}
		
	}
	
	/**
	 * Replace CellPhone object at an index
	 * @param p CellPhone object that is replaced with 
	 * @param index The position of the linked list where object is being replaced
	 */
	public void replaceAtIndex(CellPhone p, int index)
	{
		CellNode position= head;
		int count=0;
		//Return if index is invalid
		if(index<0 || index>= this.size())
		{
			return;
		}
		else
		{
			while(position!=null)
			{
				//Set the new object
				if(index==count)
				{
					position.setCp(p);
					break;
				}
				position=position.getCn();
				count++;
			}
			
		}
	}
	
	
	
	/**
	 * Determine if the linked list has the desired serial number, if so, it return the cellNode
	 * @param s The serial number that is being searched
	 * @return Return the CellNode of the CellPhone object
	 */
	public CellNode find(long s)
	{
		int count=0;
		long serial;
		CellNode position= head;
		while(position!=null)
		{
			serial=position.cp.getSerialNum();
			if(serial==s)
			{
				System.out.println("The serial number "+s+" was found at the "+count+"th iteration.");
				return position;
			}
			count++;
			position=position.getCn();
		}
		System.out.println("The serial number "+s+" was not found");
		
		return null;
		
	}
	
	/**
	 * Determine if the serial number is in the linked list
	 * @param s The serial number that is being searched
	 * @return Return true if the linked list contains the serial number, otherwise it returns false
	 */
	public boolean contains(long s)
	{
		if(find(s)!=null)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	/**
	 * Display the contents of the linked list and the number of CellPhone objects
	 */
	public void showContents()
	{
		CellNode position = head;
		System.out.println("The current size of the list is "+this.size()+". Here are the contents of the list\n=============================================================================");
		while(position!=null)
		{
			System.out.println("["+position.getCp().getSerialNum()+": "+position.cp.getBrand()+" "+position.getCp().getPrice()+"$ "+position.getCp().getYear()+"]---> ");
			position=position.getCn();
		}
		System.out.println("X");
	}
	
	/**
	 * Determine if all the CellPhone objects of two linked lists are equal
	 * @param l The other linked list that is being compared to 
	 * @return Return true if all the CellPhone objects are equal in both linked list, otherwise false
	 */
	public boolean equals(CellList l)
	{
		if(l==null)
		{
			return false;
		}
		else if(getClass()!=l.getClass())
		{
			return false;
		}
		else if(l.size()!=this.size())
		{
			return false;
		}
		else
		{
			CellNode position1=head;
			CellNode position2=l.head;
			CellPhone p1;
			CellPhone p2;
			while(position1!=null)
			{
				p1=position1.getCp();
				p2=position2.getCp();
				if(p1.equals(p2)==false)
				{
					return false;
				}
				position1=position1.getCn();
				position2=position2.getCn();
			}
			return true;
		}
	}
	
	
	
	
	
	
	

}
