import java.text.DecimalFormat;
public class HouseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat number_format= new DecimalFormat ("#.0"); 

		//Test code
		System.out.println("--------------------------Welcome to the Data House Program------------------------------- ");
		
		//Initializing the constructors
		House H1 = new House();
		House H2 = new House(100000);
		House H3 = new House(120000,4);
		House H4 = new House(220000,2,"detached");
		
		//Display data
		System.out.print("House H1: ");
		H1.outputData();
		System.out.print("House H2: ");
		H2.outputData();
		System.out.print("House H3: ");
		H3.outputData();
		System.out.print("House H4: ");
		H4.outputData();
		System.out.println();
		
		//Accessor Method 
		System.out.println("Accessor Method: The housetype for house H4 is "+ H4.getType()+", its age is "+H4.getAge()+", and it costs $"+ H4.getCost());
		System.out.println();
		
		//Estimated price for houses
		H3.estimatePrice();
		System.out.println("The estimated price of house H3 is $" + number_format.format(H3.getCost()));
		H4.estimatePrice();
		System.out.println("The estimated price of house H4 is $"+ number_format.format(H4.getCost()));
		System.out.println();
		
		//Mutator Method
		H3.setAge(5);
		System.out.println("Mutator Method: The new age for house H3 is "+H3.getAge());
		H3.setType("semi-detached");
		System.out.println("Mutator Method: The new housetype for house H3 is "+H3.getType());
		H3.setCost(240000);
		System.out.println("Mutator Method: The new cost for house H3 is "+H3.getCost());
		H3.setAgeCost(6, 245000);
		System.out.println("Mutator Method: The new house H3 age is "+H3.getAge()+ " and its new cost is "+ H3.getCost());
		H3.setData(14, "semi-detached", 260000);
		System.out.println("Mutator Method: The new housetype for house H3 is "+H3.getType()+ ", its new age is "+H3.getAge()+", and its cost is "+ H3.getCost());
		System.out.println();

		//ToString Method
		System.out.println(H3.toString());
		System.out.println();
		
		//Equality methods (equal, less and greater)
		//Equal
		System.out.println("House H1 and H2 are equal is "+H1.equals(H2));
		System.out.println("House H1 and H4 are equal is "+H1.equals(H4));
		System.out.println();

		//Less
		System.out.println("House H4 is less than H3 is "+H4.isLessThan(H3));
		System.out.println();
		
		//Greater
		System.out.println("House H1 is greater than H3 is "+H1.isGreaterThan(H3));
		
		//Display closing message
		System.out.println("\n---------------------------End of Program-------------------------------------------------  ");
		
		
	}

}
