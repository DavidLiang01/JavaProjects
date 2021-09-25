import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArithmeticCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner read=null;
		String op="";
		String[] data;
		String equ="";
		double x=0;
		double y=0;
		String strX;
		String strY;
		String result;
		int preCurrEle;
		int preTopEle=7;
		String numOp;
		String str;
		String strValue;
		boolean check=false;
		double value;
		String topOp;
		Stack<String> opStack=new ArrayStack<>();
		Stack<String> numStack= new ArrayStack<>();
	
		try 
		{
			read=new Scanner(new FileInputStream("operation.txt"));
		}
		catch (FileNotFoundException e1) 
		{
			if(read!=null)
			{
				read.close();
			}
			System.out.println("Cannot read file. Program will terminate.");
			System.exit(0);
		}
		
		PrintWriter write=null;
		try 
		{
			write=new PrintWriter(new FileOutputStream("result.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			if(write!=null)
			{
				write.close();
			}
			System.out.println("Cannot write to file. Program will terminate.");
			System.exit(0);
		}
		
		while(read.hasNextLine())
		{
			result="";
			equ="";
			str=read.nextLine();
			
			str=str.replaceAll("\\(","\\( ");
			str=str.replaceAll("\\)", " \\)");
			data=str.split("\\s");
					
			for(int i=0;i<data.length;i++)
			{
				numOp=data[i];
				equ=equ+numOp;				
				check=false;
				
				//Determine if string is a number or operator
				try
				{
					value=Double.parseDouble(numOp);
					strValue=String.valueOf(value);
					numStack.push(strValue);
				}
				catch(NumberFormatException e)
				{
					check=true;
				}
				
				if(check==true)
				{
					op=numOp;
					preCurrEle=CheckPrecedence(op);
					
					if(!opStack.isEmpty())
					{
						topOp=opStack.top();
						preTopEle=CheckPrecedence(opStack.top());
					}
					
					//Check the precedence of top element in opStack 
					//Never push ")" in the stack
					if(!op.equals(")"))
					{
						if(preCurrEle<preTopEle  || opStack.isEmpty() || op.equals("(") || opStack.top().equals("("))
						{
							opStack.push(op);
						}
					}
						
					if(!op.equals("(") && numStack.size()>=2)
					{
						while((preCurrEle>=preTopEle && numStack.size()>1 && preTopEle!=1) || op.equals(")") )
						{
							//Pop operator
							topOp=opStack.pop();
							
							//Pop 2 numbers and convert to double
							strX=numStack.pop();
							strY=numStack.pop();
							x=Double.parseDouble(strX);
							y=Double.parseDouble(strY);
					
							//Perform calculation
							result=arithmeticOp(topOp, x, y);
						
							//Push the result back
							numStack.push(result);
							
							if(!opStack.isEmpty())
							{
								preTopEle=CheckPrecedence(opStack.top());
							}
							
							if(op.equals(")") && opStack.top().equals("(")) 
							{
								opStack.pop();
								break;
							}
							
							if(!op.equals(")")) 
							{
								if((preCurrEle<preTopEle && !opStack.isEmpty()) || opStack.isEmpty() || (opStack.top().equals("(") && !op.equals(")")))
								{
									opStack.push(op);
									break;
								}
							}	
						}
					}
				}
			}
			
			while(!opStack.isEmpty() && numStack.size()>=2)
			{
				if(numStack.size()>=2)
				{
					strX=numStack.pop();
					strY=numStack.pop();
					x=Double.parseDouble(strX);
					y=Double.parseDouble(strY);
				}
				topOp=opStack.pop();
				result=arithmeticOp(topOp, x, y);
				numStack.push(result);
			}
			result=numStack.pop();
			write.println(equ);
			write.println(result+"\n");	
		}
		
		if(write!=null)
		{
			write.close();
		}
		
		if(read!=null)
		{
			read.close();
		}
		System.out.println("----------End of program-----------");
	}
	
	public static int CheckPrecedence(String op)
	{
		int order;
		switch(op) 
		{
		case "(": case ")":
			order=1;
			break;
			
		case "^":
			order=2;
			break;
			
		case "*": case "/":
			order=3;
			break;
			
		case "+": case "-":
			order=4;
			break;
			
		case "==": case "!=":
			order=5;
			break;
			
		default:
			order=5;
			break;
		}
		return order;
		
	}
	
	public static String arithmeticOp(String op, double x, double  y)
	{
		double result=-9999999;
		boolean truth=false;
		boolean display=false;
		switch(op) 
		{
		
		case "^":
			result=Math.pow(y, x);
			break;
			
		case "*":
			result=x*y;
			break;
		
		case "/":
			result=y/x;
			break;
			
		case "+": 
			result=y+x;
			break;
			
		case "-":
			result=y-x;
			break;
			
		case "==": 
			truth= y==x;
			display=true;
			break;
			
		case "!=":
			truth= y!=x;
			display=true;
			break;
			
		case "<":
			truth= y<x;
			display=true;
			break;
		
		case "<=":
			truth= y<=x;
			display=true;
			break;
			
		case ">":
			truth= y>x;
			display=true;
			break;
			
		case ">=":
			truth= y>=x;
			display=true;
			break;
		default:
			return "";			
		}
		
		if(display==true)
		{	
			return Boolean.toString(truth);
		}
		else
		{
			return Double.toString(result);
		}
	}

}
