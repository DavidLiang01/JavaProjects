
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account a =new Account();
		
		
		System.out.println(a.balance + " "+ a.nbAccounts);
		
		Account b= new Account();
		System.out.println(a.balance + " "+ a.nbAccounts);
		System.out.println(b.balance + " "+ b.nbAccounts);
		
		
		//Wrapper class
		Integer num= 67;
		System.out.println(num);
		System.out.println(Double.toString(32));

		int num1= Integer.parseInt("7689");
		System.out.println(num1);
	}

}
