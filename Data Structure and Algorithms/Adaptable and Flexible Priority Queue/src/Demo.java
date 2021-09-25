
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AFPQ<Integer, String> h= new AFPQ<>();
		AFPQ<Integer, String> h2= new AFPQ<>(9,"MAX");
		AFPQ<Integer, String> h3= new AFPQ<>(2,"MIN");

		//State method 
		System.out.println("Is the heap h as min or max? "+h.state());
		System.out.println("Is the heap h3 as min or max? "+h3.state());
		System.out.println();
		
		//Size method 
		System.out.println("The size of heap h is: "+h.size());
		System.out.println("The size of heap h3 is: "+h3.size());
		System.out.println();

		//isEmpty method 
		System.out.println("The heap h is empty? "+ h.isEmpty());
		System.out.println("The heap h2 is empty? "+ h2.isEmpty());
		System.out.println("The heap h3 is empty? "+ h3.isEmpty());
		System.out.println();


		//Insert method 
		AdaptableEntry<Integer, String> v=h.insert(2, "B");
		System.out.println("The entry "+v+" is inserted into heap h");
		AdaptableEntry<Integer, String> w=h.insert(1, "A");
		System.out.println("The entry "+w+" is inserted into heap h");
		AdaptableEntry<Integer, String> y=h.insert(3, "C");
		System.out.println("The entry "+y+" is inserted into heap h");
		AdaptableEntry<Integer, String> x=h.insert(3, "d");
		System.out.println("The entry "+x+" is inserted into heap h");
		AdaptableEntry<Integer, String> z=h.insert(1, "d");
		System.out.println("The entry "+z+" is inserted into heap h");
		System.out.println("The size of heap h is: "+h.size());
		System.out.println();



		AdaptableEntry<Integer, String> a=h2.insert(2, "B");
		System.out.println("The entry "+a+" is inserted into heap h2");
		AdaptableEntry<Integer, String> b=h2.insert(1, "A");
		System.out.println("The entry "+b+" is inserted into heap h2");
		AdaptableEntry<Integer, String> c=h2.insert(63, "C");
		System.out.println("The entry "+c+" is inserted into heap h2");
		System.out.println("The size of heap h2 is: "+h2.size());
		AdaptableEntry<Integer, String> d=h2.insert(3, "H");
		System.out.println("The entry "+d+" is inserted into heap h2");
		AdaptableEntry<Integer, String> e=h2.insert(16, "C");
		System.out.println("The entry "+e+" is inserted into heap h2");
		AdaptableEntry<Integer, String> f=h2.insert(6, "Z");
		System.out.println("The entry "+f+" is inserted into heap h2");
		AdaptableEntry<Integer, String> g=h2.insert(876, "S");
		System.out.println("The entry "+g+" is inserted into heap h2");
		AdaptableEntry<Integer, String> i=h2.insert(52, "WE");
		System.out.println("The entry "+i+" is inserted into heap h2");
		System.out.println("The size of heap h2 is: "+h2.size());
		System.out.println();

		
		
		AdaptableEntry<Integer, String> l=h3.insert(2, "B");
		System.out.println("The entry "+l+" is inserted into heap h3");
		System.out.println("The size of heap h3 is: "+h3.size());
		AdaptableEntry<Integer, String> m=h3.insert(1, "A");
		System.out.println("The entry "+m+" is inserted into heap h3");
		AdaptableEntry<Integer, String> n=h3.insert(3, "C");
		System.out.println("The entry "+n+" is inserted into heap h3");
		AdaptableEntry<Integer, String> o=h3.insert(3, "H");
		System.out.println("The entry "+o+" is inserted into heap h3");
		AdaptableEntry<Integer, String> p=h3.insert(1, "C");
		System.out.println("The entry "+p+" is inserted into heap h3");
		System.out.println("The size of heap h3 is: "+h3.size());
		System.out.println();

		System.out.println("The entries in the heap h are: "+h.display());
		System.out.println("The entries in the heap h2 are: "+h2.display());
		System.out.println("The entries in the heap h3 are: "+h3.display());

		//top method 
		System.out.println("The top of heap h is "+h.top());
		System.out.println("The top of heap h3 is "+h3.top());
		System.out.println();

		//RemoveTop method 
		System.out.println(h.removeTop()+" has been removed from the top of the heap h");
		System.out.println("The entries in the heap h are: "+h.display());
		System.out.println("The size of heap h is: "+h.size());
		System.out.println("The heap h is empty? "+ h.isEmpty());
		System.out.println();
		
		//remove method
		System.out.println(h2.remove(i)+" has been removed from heap h");
		System.out.println("The entries in the heap h2 are: "+h2.display());
		System.out.println("The size of heap h2 is: "+h2.size());
		System.out.println();

		
		//ReplaceValue method
		String temp=l.toString();
		System.out.println("The old value "+ h3.replaceValue(l, "ABC")+" of entry "+ temp+" in the heap h3 has been changed to \"ABC\"");
		System.out.println("The entries in the heap h3 are: "+h3.display());
		System.out.println();

		//ReplaceKey method 
		temp=p.toString();
		System.out.println("The old key "+ h3.replaceKey(p, 99)+" of entry "+ temp+" in the heap h3 has been changed to 99");
		System.out.println("The entries in the heap h3 are: "+h3.display());
		System.out.println();


		//toggle method 
		h3.toggle();
		System.out.println("The heap h3 has been changed to "+h3.state());
		System.out.println("The entries in the heap h3 are: "+h3.display());
		System.out.println();
		
		h2.toggle();
		System.out.println("The heap h2 has been changed to "+h2.state());
		System.out.println("The entries in the heap h2 are: "+h2.display());
		System.out.println();
		
		int l1=h.size();
		for(int in=0;in<l1;in++)
		{
			System.out.println("The top of heap h is "+h.top());
			System.out.println(h.removeTop()+" has been removed from the top of the heap h");
			System.out.println("The new top of heap h is "+h.top());
		}
		System.out.println("The size of heap h is: "+h.size());
		System.out.println("The heap h is empty? "+ h.isEmpty());
		System.out.println();


		//ReplaceKey method 
		System.out.println("Is the heap h2 as min or max? "+h2.state());
		temp=a.toString();
		System.out.println("The old key "+ h2.replaceKey(a, 99)+" of entry "+ temp+" in the heap h2 has been changed to 99");
		System.out.println("The entries in the heap h2 are: "+h2.display());
		temp=f.toString();
		System.out.println("The old key "+ h2.replaceKey(f, 23)+" of entry "+ temp+" in the heap h2 has been changed to 23");
		System.out.println("The entries in the heap h2 are: "+h2.display());
		temp=b.toString();
		System.out.println("The old key "+ h2.replaceKey(b, 5465)+" of entry "+ temp+" in the heap h2 has been changed to 5465");
		System.out.println("The entries in the heap h2 are: "+h2.display());
		temp=c.toString();
		System.out.println("The old key "+ h2.replaceKey(c, 1)+" of entry "+ temp+" in the heap h2 has been changed to 1");
		System.out.println("The entries in the heap h2 are: "+h2.display());
		System.out.println();
	
	}

}
