/*
 * 全局变量 ＝成员变量
 * 	－实例变量
 *  －类变量＝静态变量
 * 局部变量
 */

public class Dog {

	private String name;
	private int age;
	
//	局部变量:在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明和初始化都是在方法中，方法结束后，变量就会自动销毁。
//	类变量（静态变量）类变量也声明在类中，方法体之外，但必须声明为static类型。
//	成员变量（非静态变量）成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
	/**
	 * 
	 * 局部变量：
	 * 成员变量：
	 * 类变量：
	 * @param name
	 * @param age
	 */

	static HelloWorld h;
	

//成员变量又分为
//实例变量
//和
//类变量(static静态变量).在程序加载时系统就为它在堆中开辟了内存，堆中的内存地址存放于栈以便于高速访问。静态变量的生命周期--一直持续到整个"系统"关闭。 （待考量）


	float x; //x为实例变量
	static  int y; //只要有关键字static, y为类变量

	
	
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void Han(String s){
		System.out.println(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
