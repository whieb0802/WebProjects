import java.util.HashMap;  
   
public class Apple extends Object{  
    private String color;  
   
    public Apple(String color) {  
        this.color = color;  
    }  
   

	public static void main(String[] args) {  
        Apple a1 = new Apple("green");  
        Apple a2 = new Apple("red");  
   
        //hashMap stores apple type and its quantity  
        HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();  
        m.put(a1, 10);  
        m.put(a2, 20);  
        System.out.println(m.get(new Apple("green")));  
    }  
} 
