public class TestStatic {
	static {
		int x = 5;
		System.out.println("staitc");
	}
	static int x, y;

	public static void main(String args[]) {
		x--;
		myMethod();
		System.out.println(x + y + ++x);
	}

	public static void myMethod(){ 
		int a=x++;
		int b = ++x;
		y = a + b; 
		}}