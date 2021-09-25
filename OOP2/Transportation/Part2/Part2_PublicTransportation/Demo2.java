//---------------------------------------------------------------------------------------
//Assignment #2
//Part2: Demo2
//Written by David Liang (40092433)
//----------------------------------------------------------------------------------------
package Part2_PublicTransportation;

import Part2_Boat.Ferry2;
import Part2_CB_T_M.CityBus2;
import Part2_CB_T_M.Metro2;
import Part2_CB_T_M.Tram2;
import Part2_Plane.Aircraft2;
import Part2_Plane.Aircraft2.classType;
import Part2_Plane.Aircraft2.maintenance;


public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Declaring objects
		PublicTransportation2 p2 = new PublicTransportation2();
		PublicTransportation2 p3 = new PublicTransportation2(1,15);

		CityBus2 p4 = new CityBus2(3.25,10,111111,2019, "cityBusline2","cityBusdriver");
		CityBus2 p5 = new CityBus2(2.5,12,111111,2018, "cityBusline","cityBusdriver3");

		Metro2 p7 = new Metro2(2,60,222222,2020,"metroline","metrodriver4",40,"Montreal");
		Metro2 p8 = new Metro2(1.50,60,333333,2020,"metroline2","metrodriver2",20,"Toronto");

		Tram2 p10 = new Tram2(9,30,333333,2022,"tramline","tramdriver1", 100);
		Tram2 p11 = new Tram2(5,30,333333,2022,"tramline2","tramdriver", 100);

		Ferry2 p12 = new Ferry2(5,1,1990, "ferryname1");
		Ferry2 p13 = new Ferry2(2,9,1999, "ferryname2");

		Aircraft2 p14 = new Aircraft2(88,88,classType.GLIDER,maintenance.MONTHLY);
		Aircraft2 p15 = new Aircraft2();
		
		
		PublicTransportation2[] arr= new PublicTransportation2[12];
		PublicTransportation2[] copyArr;

		arr[0]=p2;
		arr[1]=p3;
		arr[2]=p4;
		arr[3]=p5;	
		arr[4]=p7;
		arr[5]=p8;
		arr[6]=p10;
		arr[7]=p11;
		arr[8]=p12;
		arr[9]=p13;
		arr[10]=p14;
		arr[11]=p15;
		
		//Copy the array
		copyArr= copyCityBus(arr);
		System.out.println("Array of 12 objects");
				
		//Display content of the array
		for (int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i].toString());
		}
		
		System.out.println("\n\n\n");
		System.out.println("Copied CityBus objects");
		
		//Display content of the copied array
		for (int i=0;i<copyArr.length && copyArr[i]!=null;i++)
		{
			System.out.println(copyArr[i].toString());
		}
	}
	

	/*
	 * The copying of the objects from the initial array to the copy array is not correct because polymorphism doesn't apply
	 * to constructors and each class has its own copy constructors with different attributes, so the copy  of the 
	 * PublicTransportation has only ticketPrice and numberStops as attributes so, it will only copy and display these attributes.
	 * In order to properly copy the objects in the array, the clone method should be used because the clone method is built into every class
	 * or we determine the class of every elements and then cast the elements to their respective class that they belong to in the copy constructor 
	 */
	
	//This method only prints the CityBus class which is cityBus, Metro and Tram using the copy constructor of PublicTransportation
	public static PublicTransportation2[] copyCityBus(PublicTransportation2[] arr)
	{
		int index=0;
		PublicTransportation2[] copyarr= new PublicTransportation2[arr.length];
		
		//Copy CityBus class
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i] instanceof CityBus2)  //CityBus has metro and tram as child and they are all cityBus class
			{
				copyarr[index]=new PublicTransportation2(arr[i]);
				index++;	
			}
		}
		return copyarr;	
	}
	

	

}
