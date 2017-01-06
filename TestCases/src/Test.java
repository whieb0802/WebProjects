public class Test {
	static int[] ax = new int[3];
	public final int MAX_LENGTH1=100;
	final public int MAX_LENGTH=100;
	static boolean b1;
	long ss[] = new long[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		add(a);
		String str = null;
		System.out.println(str);
		System.out.println(a);
		System.out.println(ax[1]);
//		System.out.print(ss[6]);
		String  s ="string";
		s= s +10;
		System.out.println(s);
		boolean b2 = true;
		System.out.println(b1);

		int i =2;
		int j=1;
		long l= 4990;
		float f =1.1f;
		String af = "a";
		switch (af) { 
			case "a": System.out.println("Condition 0"); 
			case "b": 
			case "c": System.out.println("Condition 2"); 
			case "d": System.out.println("Condition 3"); 
			break; }
		
		switch(0){ case 1: System.out.println("Test1"); case 2: case 3: System.out.println("Test2"); break; } System.out.println("Test3");
		
	}

	static int add(int x) {
		x++;
		return x;
	}

}
