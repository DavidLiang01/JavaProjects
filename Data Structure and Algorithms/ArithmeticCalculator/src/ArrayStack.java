
public class ArrayStack<E> implements Stack<E>{

	private static final int DEFAULTCAPACITY=10;
	private int currentSize=0;
	private int capacity;
	private E[] arr;
	
	
	public ArrayStack()
	{
		this.capacity=DEFAULTCAPACITY;
		arr= (E[]) new Object[DEFAULTCAPACITY];
	}
	public ArrayStack(int s)
	{
		this.capacity=s;
		arr= (E[]) new Object[s];
	}
	
	public int size()
	{
		return currentSize;
	}
	
	public boolean isEmpty()
	{
		return currentSize==0;
	}
	
	public void push(E e)
	{
		
		if(currentSize==arr.length)
		{
			//increment size with constant c and add element

			E[] arr2= (E[]) new Object[arr.length+5];
			
			//Transfer all elements of old array to new array
			for(int i=0;i<arr.length;i++)
			{
				arr2[i]=arr[i];
			}
			
			//Assign reference of old array to new array
			arr=arr2;
			
		}
		
		//Push the new element
		arr[currentSize]=e;
		currentSize++;
		
		
	}
	
	public E pop()
	{
		if(isEmpty()==true)
		{
			return null;
		}
		E topElement=arr[currentSize-1];
		arr[currentSize-1]=null;
		currentSize--;
		return topElement;
	}
	
	public E top()
	{
		if(isEmpty()==true)
		{
			return null;
		}
		
		return arr[currentSize-1];
	}
	
	
}
