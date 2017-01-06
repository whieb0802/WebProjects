import java.util.Arrays;


public class Test02bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,5,2,1};
		arr = Test02bubbleSort.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static int[] bubbleSort(int[] x){
		
		for(int i = 0;i < x.length-1;i++){
			for(int j = 0; j<x.length-i-1;j++){
				if(x[j] > x[i]){
					int t = x[j];
					x[j] = x[i];
					x[i] = t;
				}
			}
		}
		
		return x;
	}

}
