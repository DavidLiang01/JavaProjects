
public class AdaptableEntry<K,V>{
	
	private int index;	
	private K k;
	private V v;
	
	//Parameterized constructor with key, value, index
	public AdaptableEntry(K key, V value, int j)
	{
		this.k=key;
		this.v=value;
		index=j;
	}
	
	//Parameterized constructor with key, value 
	public AdaptableEntry(K key, V value)
	{
		this.k=key;
		this.v=value;
	}
	
	//Get method for key
	public K getKey()
	{
		return k;
	}
	
	//Get method for value
	public V getValue()
	{
		return v;
	}
	
	//Set method for key
	public void setKey(K key)
	{
		this.k=key;
	}
	
	//Set method for value
	public void setValue(V value)
	{
		this.v=value;
	}
	
	//Get method for index
	public int getIndex()
	{
		return index;
	}
	
	//Set method for index
	public void setIndex(int j)
	{
		this.index=j;
	}
	
	//ToString method to display attributes
	public String toString()
	{
		return "("+this.getKey()+", "+this.getValue()+")";
	}

}
