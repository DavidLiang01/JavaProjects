
public class TemperatureDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Temperature t1 =new Temperature(30, 'F');
		Temperature t2= new Temperature(15, 'C');
		
		System.out.println("t1 is hotter than t2: " +t1.isHotter(t2));
		System.out.println(t1.getTempInCelsius());
		System.out.println(t1.add(t2));

		
	}

}
