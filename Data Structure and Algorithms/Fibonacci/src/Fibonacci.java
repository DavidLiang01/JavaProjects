import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintWriter write=null;
		long startTime;
		long endTime;
		long elapsedTime;
		
		try 
		{
			write=new PrintWriter(new FileOutputStream("out.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Cannot write to file. Program will terminate.");
			
			if(write!=null)
			{
				write.close();
			}
			System.exit(0);
		}
		
		System.out.println("Binary Recusion");
		write.println("Binary Recursion Time in millisecond:\n");
		for(int i=5;i<=40;i=i+5)
		{
			startTime=System.currentTimeMillis();
			System.out.print(ExponentialTetranacci(i)+", ");
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			write.println("The time for ExponentialTetranacci("+i+") in milliseconds is: "+elapsedTime);  
	
		}
		
		System.out.println("\n\nLinear Recursion");
		write.println("\n\nTail Recursion Time in nanosecond:\n");

		BigInteger startTime2;
		BigInteger endTime2;
		BigInteger elapsedTime2;

		for(int i=5;i<=100;i=i+5)
		{
			startTime2=BigInteger.valueOf(System.nanoTime());
			System.out.print(TRTetranacci(i).toString()+", ");
			endTime2=BigInteger.valueOf(System.nanoTime());		
			elapsedTime2=endTime2.subtract(startTime2);
			write.println("The time for ExponentialTetranacci("+i+") in nanoseconds is: "+elapsedTime2.toString());  
	
		}
		

		if(write!=null)
		{
			write.close();
		}
		
		
	}

	public static long ExponentialTetranacci(long n)
	{
		if(n<=2)
		{
			return 0;
		}
		else if(n==3)
		{
			return 1;
		}
		else
		{

			return ExponentialTetranacci(n-1)+ExponentialTetranacci(n-2)+ExponentialTetranacci(n-3)+ExponentialTetranacci(n-4);
		}
		
		
	}
	
	public static BigInteger TRTetranacci(long n)
	{
		//Return 0 when n is from 0 to 2 since we know that it is 0 for these n values
		if(n<=2)
		{
			return BigInteger.valueOf(0);
		}
		//Return 1 at n=3
		else if(n==3)
		{
			return BigInteger.valueOf(1);
		}
		else
		{
			return TR2(BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(1),n);
		}
		
		
	}
	
	public static BigInteger TR2(BigInteger num1, BigInteger num2,BigInteger num3,BigInteger num4, long n)
	{
		BigInteger sum;
		//return the sum
		if(n==3)
		{
			return num4;
		}
		//add
		sum=num1.add(num2);
		sum=num3.add(sum);
		sum=num4.add(sum);
		return TR2(num2,num3,num4,sum,n-1);
	}
}
