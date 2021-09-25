
public class Temperature {

	private double temp;
	private char scale;
	
	public Temperature()
	{
		temp=0;
		scale='C';
	}
	
	public Temperature(double value, char s)
	{
		temp=value;
		if (s!='C'&& s!='F')
		{
			scale='C';
		}
		else 
		{
			scale=s;
		}
	}
	
	public double getTempInCelsius()
	{
		if (scale=='C') 
		{
			return temp;
		}
		else
		{
			return (5.0/9)*(temp-32);
		}
	}
	
	public void setData(double value, char s)
	{
		if (s!='C'&& s!='F')
		{
			scale='C';
			temp=value;
		}
		else
		{
			temp=value;
			scale=s;
		}
	}
	
	public boolean isHotter(Temperature anotherTemp)
	{
		if (scale!='C')
		{
			temp = (5/9)*(temp-32);
		}
		if (this.temp>anotherTemp.temp)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public String toString()
	{
		return ("The temperature is: "+temp+scale);
	}
	
	public double add(Temperature anotherTemp)
	{
		if (this.scale !='C')
		{
			this.temp= (5/9)*(this.temp-32);
		}
		if (anotherTemp.scale !='C')
		{
			anotherTemp.temp= (5/9)*(anotherTemp.temp-32);
		}
		 return (this.temp + anotherTemp.temp);
	}
}
