import java.util.Arrays;


public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,5,2,1};
		SelectionSort.SelectionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static int[] SelectionSort(int[] x){
		
		for(int i = 0;i < x.length-1;i++){
			for(int j = i+1; j<x.length;j++){
				if(x[j]<x[i]){
					int t = x[j];
					x[j] = x[i];
					x[i] = t;
				}
			}
		}
		
		return x;
	}

}
