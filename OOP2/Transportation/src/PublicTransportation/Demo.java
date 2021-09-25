//---------------------------------------------------------------------------------------
//Assignment #2
//Part1: Demo
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------
package PublicTransportation;

import Boat.Ferry;
import CB_T_M.CityBus;
import CB_T_M.Metro;
import CB_T_M.Tram;
import Plane.Aircraft;
import Plane.Aircraft.classType;
import Plane.Aircraft.maintenance;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double max;
		double min;
		
		//Declaring objects
		PublicTransportation p1 = new PublicTransportation();
		PublicTransportation p2 = new PublicTransportation();
		PublicTransportation p3 = new PublicTransportation(1,15);

		CityBus p4 = new CityBus(3.25,10,111111,2019, "cityBusline1","cityBusdriver");
		CityBus p5 = new CityBus(2.5,12,111111,2018, "cityBusline","cityBusdriver5");
		CityBus p6 = new CityBus(3.25,10,111111,2019, "cityBusline2","cityBusdriver4");

		Metro p7 = new Metro(2,60,222222,2020,"metroline","metrodriver",40,"Montreal");
		Metro p8 = new Metro(1.50,60,333333,2020,"metroline","metrodriver2",20,"Toronto");
		Metro p9 = new Metro(1.50,60,444444,2020,"metroline3","metrodriver",10,"Montreal");

		Tram p10 = new Tram(9,30,333333,2022,"tramline","tramdriver", 100);
		Tram p11 = new Tram(5,30,333333,2022,"tramline4","tramdriver", 100); 

		Ferry p12 = new Ferry(5,1,1990, "ferryname1");
		Ferry p13 = new Ferry(88,9,1999, "ferryname2");

		Aircraft p14 = new Aircraft(88,88,classType.GLIDER,maintenance.MONTHLY);
		Aircraft p15 = new Aircraft();
	

		//fill the array with various objects
		PublicTransportation[] a= new PublicTransportation[15];
		a[0]=p1;
		a[1]=p2;
		a[2]=p3;
		a[3]=p4;
		a[4]=p5;	
		a[5]=p6;
		a[6]=p7;
		a[7]=p8;
		a[8]=p9;
		a[9]=p10;
		a[10]=p11;
		a[11]=p12;
		a[12]=p13;
		a[13]=p14;
		a[14]=p15;
		
		
		System.out.println("Information of the objects:");
		for (int i=0;i<a.length;i++)
		{
			System.out.println(a[i].toString());
		}
		
		//equality of objects
		System.out.println("\n\n\nequality of the objects:");
		System.out.println("The object p1 and p2 are equal: "+p1.equals(p2));
		System.out.println("The object p3 and p4 are equal: "+p3.equals(p4));
		System.out.println("The object p5 and p6 are equal: "+p5.equals(p6));
		System.out.println("The object p6 and p7 are equal: "+p6.equals(p7));
		System.out.println("The object p5 and p5 are equal: "+p5.equals(p5));
		System.out.println("The object p4 and p6 are equal: "+p4.equals(p6));
		System.out.println("The object p8 and p9 are equal: "+p8.equals(p9));
		System.out.println("The object p9 and p15 are equal: "+p9.equals(p15));
		System.out.println("The object p12 and p13 are equal: "+p12.equals(p13));
		System.out.println("The object p14 and p15 are equal: "+p14.equals(p15));


		

		min=a[0].ticketPrice;
		max=a[0].ticketPrice;
		//Search for the lowest/greatest price
		for (int i=0; i<a.length;i++)      
		{
			if (a[i].ticketPrice<min)
			{
				min=a[i].ticketPrice;
			}
			if(a[i].ticketPrice>max)
			{
				max=a[i].ticketPrice;
			}
		}
		
		System.out.println("\n\n\n");
		//Display the object that has the lowest and highest ticket price
		for(int i=0;i<a.length;i++)
		{
			if(a[i].ticketPrice==min)
			{
				System.out.println("The lowest ticket price is the object at the " + i+ "th index. Information: "+a[i].toString());
			}
		}
		for(int i=0;i<a.length;i++)
		{
			if(a[i].ticketPrice==max)
			{
				System.out.println("The highest ticket price is the object at the " + i+ "th index. Information: "+a[i].toString());
			}
		}
	}

}
