class Super {
	public int getLength() {
		return 4;
	}
}

public class Sub extends Super {
	public int getLength() {
		return 5;
	}

	public static void main (String[]args) { Super sooper = new Super (); 
	
	int index = 1; 
	String [] test = new String[3]; 
	String foo = test[index];
	System.out.println(foo);
	
	
	Super sub = new Sub(); 
	System.out.println(sooper.getLength()+ "," + sub.getLength() ); }}