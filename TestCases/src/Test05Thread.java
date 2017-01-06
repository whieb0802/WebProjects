
public class Test05Thread {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person2 p2 = new Person2();
		p1.start();
		p2.start();
		System.out.println("main over!");
	
	}

static	class Person extends Thread{
		public void run(){
			for(int i = 0;i<100;i++){
				System.out.println("你是谁啊?");
			}
		}
	}
static	class Person2 extends Thread{
		public void run(){
			for(int i = 0;i<100;i++){
				System.out.println("工程师！");
			}
		}
	}
}
