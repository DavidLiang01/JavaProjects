import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard= new Scanner(System.in);
	
		String str="EINSTEIN’S";
		String str2="B";
//		System.out.println(str.compareTo(str2));
		
//		if(str.contains("'")==true)
//		{
//			System.out.println(str.contains("'"));
//			str=str.substring(0,str.indexOf("'"));
//			System.out.println(str);
//
//		}
		
		if(str.contains("’")==true)
		{
			System.out.println(str.contains("’"));
			str=str.substring(0,str.indexOf("’"));
			System.out.println(str);		}
//		
//		if(str.contains("I")==true)
//		{
//			str=str.substring(0,str.indexOf("I"));
//		}
		
//		String[] a= {"blue", "yellow", "orange", "white", "red", "black"};
//		String[] a= {"sad", "yersty", "sads","qwer", "yrter","poiu","asd","zxc","white", "red", "black","zxcxc"};

//		ArrayList<String> a= new ArrayList<String>(Arrays.asList("sad", "yersty", "sads","qwer", "yrter","poiu","asd","zxc","white", "red", "black","zxcxc"));
//		String s1="";
//		String s2="";
//		String temp="";
//		int min=0;
//		
//		for(int j=0;j<a.size();j++)
//		{	
//			
//			s1=a.get(j);
//			min=j;
//			for(int i=j;i<a.size();i++)
//			{
//				s2=a.get(i);
//				
//				if(s2.compareTo(s1)<0)
//				{
//					min=i;
//					s1=a.get(i);			
//				}
//			}
//			temp=a.get(min);
//			a.set(min, a.get(j));
//			a.set(j, temp);
//		}
		
//		for(int j=0;j<a.length;j++)
//		{	
//			s1=a[j];
//			min=j;
//			for(int i=j;i<a.length;i++)
//			{
//				s2=a[i];
//				
//				if(s2.compareTo(s1)<0)
//				{
//					min=i;
//					s1=a[i];			
//				}
//			}
//			temp=a[min];
//			a[min]=a[j];
//			a[j]=temp;
//		}
		
//		for (int i=0;i<a.length;i++)
//		{
//			System.out.print(a[i]+" ");
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		ArrayList<String> arr= new ArrayList<String>();
//		arr.add("s1");
//		arr.add("s2");
//		System.out.println("Before");
//		for (String element : arr)
//		{
//			System.out.println(element);
//		}
//		
//		System.out.println("After");
//		arr.set(1,"s3");
//		for (String element : arr)
//		{
//			System.out.println(element);
//		}
		
//		System.out.println(str.compareTo(str2));

		
//		System.out.println(str.matches(".*\\d.*"));
//		System.out.println(str.contains("'"));
//		System.out.println(str=str.substring(0,str.indexOf("'")));

//		if(str.matches("[.]")==true)
//		{
//			System.out.println(str.substring(0,str.length()-2));
//		}
//		StringTokenizer st;
//		String s="Kun-Lung Wu and P. S. Yu and J. L. Wolf";
//		String s="X. Li and M. A. Salehi and M. Bayoumi and N. F. Tzeng and R. Buyya";
//		String s="M. B. Khan and H. Nisar and C. A. Ng";
//		String s="T. K. Roman and C. Henry Jr. and L. Fevens";
//		String s="M. Claeys and N. Bouten and D. De Vleeschauwer and W. Van Leekwijck and S. LatrÃ© and F. De Turck";
//		String[] arr=null;
//		String letter="";
//		arr=s.split("\\sand\\s");
//		int firstName=0;
//		boolean singleLetter=false;
//		for(int i=0;i<arr.length;i++)
//		{
//			//use indexOf--> to find the first empty space between first name
//			//and last name
////			arr[i]=arr[i].substring(arr[i].indexOf(" "));
//			firstName=0;
//			if(arr[i].indexOf(".")==-1)
//			{
//				arr[i]=arr[i].substring(arr[i].lastIndexOf(" ")+1);
//			}
//			else
//			{
//				arr[i]=arr[i].substring(arr[i].lastIndexOf(".")+2);
//			}
			//--------------------------------------------------------------
			//Remove spaces and characters(author first name)
//			authors[scan]=authors[scan].substring(authors[scan].indexOf(" "));
//			st0=new StringTokenizer(authors[scan],"\\p{.}");
//			while(st0.hasMoreTokens())
//			{
//				letter=st0.nextToken().trim();
//				if(letter.length()>1)
//				{
//					//Store authors' last name in array
//					authors[scan]=letter;
//					System.out.println(authors[scan]);
//				}
//
//			}
//			System.out.println("step2");
//			while(authors[scan].indexOf(".")!=-1 && authors[scan].lastIndexOf(".")!=authors[scan].length()-1)
//			{
//				authors[scan]=authors[scan].substring(authors[scan].indexOf("."));
//			}
//			System.out.println("step3");
//			System.out.println(authors[scan]);
//			System.out.println(authors[scan].lastIndexOf("."));
//			//See if string ends with . like Henry Jr.
			//-------------------------------------------------------------
//			st=new StringTokenizer(arr[i],"\\p{.}");
//			while(st.hasMoreTokens())
//			{
//				singleLetter=true;
//				letter=st.nextToken().trim();
//				//Determine if the first name is with single letter notation
//				if(letter.length()>1)
//				{
//					singleLetter=false;
////					arr[i]=letter;
////					firstName++;
//				}
//				if(singleLetter==true && letter.length()>1)
//				{
//					arr[i]=letter;
//				}
//				if(singleLetter==false)
//				{
//					letter=arr[i].substring(arr[i].indexOf(" "));
//
//					arr[i]=letter;
//				}
////				if(firstName==0 && letter.length()>1)
////				{
////					arr[i]=st.nextToken();
////				}
//				
//			}
//		}
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			
//			System.out.println(arr[i] +" length is "+arr[i].length());
//			
//		}
//		s=s.replaceAll("\\s\\band\\b", ",");
//		System.out.println(s);
		
//		int x = 5;
//		double y = 9;
//	    double num =x/y;
//	    byte aByte = 3;
//	    int a = 7;
//	    int b = 4;
//	    int c;
//	    double d;
//	    double e = 9;
//	    
//	    c = a/b;
//	    System.out.println(c);
//	    
//	    d = a/b;
//	    System.out.println(d);
//	    
//	    //c = e/a;     NOT GOOD
//	    
//	    if (x>1000)
//	    if (y>0)                             //        Line 26 to 30 is ONE STATEMENT !!!!
//	    System.out.println(a);	             //
//	    else                                 //
//	    System.out.println(b);               //
//	    System.out.println(x);              //
//	    //aByte = x;        NOT GOOD
//	    aByte = (byte)x;
//	    
//	    num = (int)num;
//	    System.out.println(num);
//	    
//	    //for (int sum = 0, double unk = 1; sum <100; sum++);  NOT ALLOW TO HAVE TWO TYPES e.g int and double in this case 
//
//	    
//	    int number = 10;
//	    while (number > 0)
//	    {
//	    	number = number - 2;
//	    	if (number == 4)
//	    	break;
//	    	System.out.println(number);
//	    	
//	    }
//	    System.out.println("The end");
//	    
////-----------------------------------------------------------------	    
//	    int number1 = 10;
//	    while (number1 > 0)
//	    {
//	    	number1 = number1 - 2;
//	    	if (number1 == 4)
//	    	continue;
//	    	System.out.println(number1);
//	    	
//	    }
//	    System.out.println("The end");
		
//		String s="2";
//		System.out.println(s += "asfd");
//--------------------------------------------------------------------------------------------
//		int n1;
//		int n2;
//		System.out.println("enter first integer");
//		n1=keyboard.nextInt();
//		System.out.println("enter second integer");
//		n2= keyboard.nextInt();
//		
//		
		//----------------------------------------------------------
//		int n;
//		System.out.println("enter integer");
//		n=keyboard.nextInt();
//		for(int j=0;j!=(n/2);j++)
//		{	
//			for (int i=0;i<n;i++)
//			{
//				if((i<j || (i+j)>=n))
//				{
//					System.out.print("-");
//				}
//				else
//				{
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
//		for(int j=0;j!=(n/2)-1;j++)
//		{	
//			for (int i=0;i<n;i++)
//			{
//				if((i<=j || (i+j)>=n-1))
//				{
//					System.out.print("-");
//				}
//				else
//				{
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
		
//		int a=1,b=2,c=5,d;
//		d= b++ +a* ++b;
//		System.out.println(d);
		
		
	}
//	public static boolean reverseSame(int n)
//	{
//		 int temp = 0;
//		    int count = 0;
//
//		    while(n != 0)
//		    {
//		        if(n%10 == 0)
//		        count++;
//		        temp = temp*10 + n %10;
//		        n /= 10;
//		    }
//		    for(int i = 0; i < count; i++)
//		    {
//		        System.out.print(0);
//		    }
//		    System.out.println(temp);
//
//		
//		return true;
//	}

}
