import java.util.Comparator;

public class AFPQ<K,V>{
	
	private static final int DEFAULTCAPACITY=10;
	private int capacity;   //Maximum capacity of the array
	private int currentSize=0;  //number of elements in the array
	private AdaptableEntry<K,V>[] h;   
	private Comparator<K> comp;
	private static final String MINTYPE="MIN";
	private static final String MAXTYPE="MAX";
	private String type;

	//Constructor to compare the entries
	private AFPQ(Comparator<K> c)
	{
		this.comp=c;
	}
	
	//Default constructor
	public AFPQ()
	{
		this(new DefaultComparator<K>()); 
		this.capacity=DEFAULTCAPACITY;
		h=new AdaptableEntry[DEFAULTCAPACITY];
		type=MINTYPE;
	}
	
	//Parameterized constructor
	public  AFPQ(int l, String s)
	{
		this(new DefaultComparator<K>()); 
		this.capacity=l;
		h= new AdaptableEntry[l];
		type=s;
	}
	
	//Set the current size of the array
	public void setCurrentSize(int s)
	{
		this.currentSize=s;
	}
	
	//isEmpty method
	public boolean isEmpty() 
	{
		return this.currentSize==0;
	}
	
	//Size method
	public int size()         
	{
		return this.currentSize;
	}
	
	//Helping methods
	
	//Find the parent of a child
	private int parent(int j)
	{
		return (j-1)/2;
	}
	
	//Find the left child of the parent
	private int left(int j)
	{
		return 2*j +1;
	}
	
	//Find the right child of the parent
	private int right(int j)
	{
		return 2*j+2;
	}
	
	//Determine if the parent has a left child
	private boolean hasLeft(int j)            
	{
		return left(j) < size();
	}
	
	//Determine if the parent has a right child
	private boolean hasRight(int j)         
	{
		return right(j)< size();
	}
	
	//Determine if we need to swap the parent into the child location 
	private void downheap(int j)
	{
		//check if the parent has a left child, if so, do we need to swap the parent and child to keep the min or max heap property
		while(hasLeft(j))
		{
			int leftIndex=left(j);
			int smallChildIndex=leftIndex;
			int bigChildIndex=leftIndex;

			//check if the parent has a right child, if so, is it bigger than the left child 
			if(hasRight(j))
			{
				int rightIndex=right(j);
				bigChildIndex=rightIndex;

				if(compare(h[leftIndex], h[rightIndex])>0)
				{
					smallChildIndex=rightIndex;	
					bigChildIndex=leftIndex;
				}
				
			}
			
			//No need to swap
			if(this.state().equals("MIN") && compare(h[smallChildIndex], h[j])>=0 )
			{
				break;
			}
			
			if(this.state().equals("MAX") && compare(h[bigChildIndex], h[j])<=0)
			{
				break;
			}
			
			//Swap parent and child
			if(this.state().equals("MIN"))
			{
				swap(j, smallChildIndex);
				j=smallChildIndex;
			}
			else
			{
				swap(j,bigChildIndex);
				j=bigChildIndex;
			}
			
		}
	}
	

	//Method that returns the top entry without removing it
	public AdaptableEntry<K,V> top()   
	{
		if(size()==0)
		{
			return null; 
		}
		return h[0];
	}

	//Method that removes the root 
	public AdaptableEntry<K,V> removeTop()   
	{
		if(size()==0)
		{
			return null;
		}
		AdaptableEntry<K,V> answer=h[0];
		swap(0,size()-1);
		h[size()-1]=null;
		setCurrentSize(size()-1);
		downheap(0);
		return answer;
	}

	//Perform downheap or upheap
	private void bubble(int j)
	{
		if(j>0 && (compare(h[j], h[parent(j)])<0 && this.state().equals("MIN")) || (compare(h[j], h[parent(j)])>0 && this.state().equals("MAX")))
		{
			upheap(j);
		}
		else
		{
			downheap(j);
		}
	}
	
	//Check if the key are of the same type
	private boolean checkKey(K key) throws IllegalArgumentException
	{
		try
		{
			return (comp.compare(key,key)==0);
		}
		catch(ClassCastException e)
		{
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	
	//Determine if the heap is max or min
	public String state()
	{
		return this.type;
	}

	//Validate the entry if it is in the heap
	private AdaptableEntry<K,V> validate(AdaptableEntry<K,V> entry)
	{
		
		//Different entry type?
		if(!(entry instanceof AdaptableEntry)) 
		{
			throw new IllegalArgumentException("Invalid entry");
		}
		K k=entry.getKey();
		AdaptableEntry<K,V> l= entry;

		//Is it in the array or does it match with the entry in the array
		int j=l.getIndex();
		if(j>=size() || h[j]!=l)
		{
			throw new IllegalArgumentException("Invalid entry");
		}
		return l;
		
	}
	
	
	//Method that swap 2 entries
	private void swap(int i, int j)
	{
		AdaptableEntry<K,V> temp=h[i];
		h[i]=h[j];
		h[j]=temp;	
		h[i].setIndex(i);  //Change the new element to new index
		h[j].setIndex(j);
	}
	
	//Compare 2 entries
	private int compare(AdaptableEntry<K,V> a, AdaptableEntry<K,V> b)
	{
		return comp.compare(a.getKey(), b.getKey());
	}
	
	
	//Swap the child to the parent location to keep the min or max heap property
	private void upheap(int j)
	{
		//Continue to swap until it reaches the root
		while(j>0)
		{
			int p=parent(j);
			if(compare(h[j], h[p])>=0 && this.state().equals("MIN"))
			{
				break;
			}
			
			if(compare(h[j], h[p])<=0 && this.state().equals("MAX"))
			{
				break;
			}
			
			swap(j,p);
			j=p;
			
		}
	}
	
	
	//Insert entry with a key and value
	public AdaptableEntry<K,V>  insert(K key, V value) throws IllegalArgumentException 
	{
		//Check if the key is of the same type 
		checkKey(key);
		
		//Increase the size of the array if the array is full, then transfer old elements to the new array
		if(size()==this.capacity)
		{
			AdaptableEntry<K,V>[] h2= new AdaptableEntry[this.capacity+5];
			for(int i=0;i<h.length;i++)
			{
				h2[i]=h[i];
			}
			h=h2;
		}
		//Insert new entry at the end of the array size
		AdaptableEntry<K,V> newEntry= new AdaptableEntry<>(key,value, size());
		h[size()]=newEntry;
		setCurrentSize(size()+1);
		upheap(size()-1);
		return newEntry;
	}
	
	
	//Remove method that remove an entry
	public AdaptableEntry<K,V> remove(AdaptableEntry<K,V> entry) throws IllegalArgumentException 
	{
		AdaptableEntry<K,V> l=validate(entry);
		int j=l.getIndex();
		
		//Remove at the entry when it is at the last element of the array
		if(j==size()-1)
		{
			h[size()-1]=null;
			setCurrentSize(size()-1);
		}
		
		//Remove if the entry is at the root
		else if(j==0)
		{
			this.removeTop();
		}
		else
		{
			swap(j,size()-1);
			h[size()-1]=null;
			setCurrentSize(size()-1);
			bubble(j);
		}
		return entry;
	}
	
	//Method that replaces the value of an entry with a new value
	public V replaceValue(AdaptableEntry<K,V> entry, V value) throws IllegalArgumentException
	{
		AdaptableEntry<K,V> l=validate(entry);
		V old;
		old=(V) l.getValue();
		l.setValue(value);
		return old;
	}
	
	//Method that replaces the key of an entry with a new key
	public K replaceKey(AdaptableEntry<K,V> entry, K key) throws IllegalArgumentException
	{
		AdaptableEntry<K,V> l=validate(entry);
		K old;
		checkKey(key);
		old= (K) l.getKey();
		l.setKey(key);
		bubble(l.getIndex());
		return old;
	}
	
	//Convert a min to max heap and vice versa
	public void toggle()
	{
		if(this.state().equals("MIN"))
		{	
			this.type=MAXTYPE;
		}
		else
		{
			this.type=MINTYPE;
		}
		
		int j=this.size()-1;
		while(j>0)
		{
			int p=parent(j);
			if(compare(h[j], h[p])<0 && this.state().equals("MIN"))
			{
				swap(j,p);
				downheap(j);
			}
			
			if(compare(h[j], h[p])>0 && this.state().equals("MAX"))
			{
				swap(j,p);
				downheap(j);
			}
			j--;
		}
	}
	
	//Print entries of the heap
	public String display()
	{
		String s="";
		for(int i=0;i<this.size();i++)
		{
			s=s+h[i]+" ";
		}
		return s;
	}
}
